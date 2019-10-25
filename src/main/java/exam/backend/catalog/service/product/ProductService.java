package exam.backend.catalog.service.product;

import exam.backend.catalog.db.entity.category.Category;
import exam.backend.catalog.db.entity.product.Distributor;
import exam.backend.catalog.db.entity.product.Product;
import exam.backend.catalog.db.mapper.product.ProductMapper;
import exam.backend.catalog.db.repository.product.ProductQuery;
import exam.backend.catalog.db.repository.product.ProductRepository;
import exam.backend.catalog.service.company.CompanyService;
import exam.backend.common.db.validation.ValidateResult;
import exam.backend.common.service.BaseEntityService;
import exam.backend.common.service.ServiceResult;
import exam.backend.common.util.StringUtils;
import exam.backend.common.util.Utils;
import exam.client.catalog.dto.filter.ProductFilterDto;
import exam.client.catalog.dto.response.product.ProductResponse;
import exam.client.catalog.dto.response.product.SimpleProductResponse;
import exam.client.common.dto.pager.PageDto;
import exam.client.common.dto.pager.PageResource;
import exam.client.common.dto.response.JsonResponse;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.IntStream;

@Service
public class ProductService extends BaseEntityService<Product, ProductRepository> {

    @Resource
    ProductQuery productQuery;
    @Resource
    private ProductRepository productRepository;
    @Resource
    private ProductMapper productMapper;
	@Resource
    CompanyService companyService;


	@Autowired
    HttpServletRequest request;



    @Override
    public ServiceResult<Product> save(Product entity) {



//		UserResponse loggedUser = TokenUtils.getLoggedUser(request);
//		if (entity.getId() == null) {
//			entity.setManualCreated(true);
//			ServiceResult<Company> companyServiceResult = companyService.get(loggedUser.getCompany().getId());
//			entity.setOwner(companyServiceResult.getValue());
//		}

		Iterator<Distributor> iterator = entity.getDistributors().iterator();
		while (iterator.hasNext()) {
			Distributor distributor = iterator.next();

//			boolean admin = loggedUser.getPermissions().contains("ADMIN");
//
//			if (admin || distributor.getCompany().getId().equals(loggedUser.getCompany().getId())) {
//				distributor.setProduct(entity);
//			}else{
//				iterator.remove();
//			}

		}

		return super.save(entity);
	}

	public ServiceResult<Product> erpSave(Product entity) {
		return super.save(entity);
	}

	@Override
    public ProductRepository getRepository() {
        return productRepository;

    }

    public JsonResponse<List<ProductResponse>> getProductsByIds(List<Long> idList) {
        JsonResponse<List<ProductResponse>> jsonResponse = new JsonResponse<>();
        jsonResponse.setResult(new ArrayList<>());

        List<Product> products = getRepository().findProductsByIdIn(idList);

        products.forEach(p -> {
            jsonResponse.getResult().add(productMapper.toResponse(p));
        });

        return jsonResponse;
    }

    public JsonResponse<ProductResponse> saveProduct(Product product) {
        JsonResponse<ProductResponse> jsonResponse = new JsonResponse<>();

        Set<Category> categories = new HashSet<>();
        //		product.getCategories().stream().filter(cat -> cat.getId() != null).forEach(cat -> {
        //			ServiceResult<Category> categoryServiceResult = categoryService.get(cat.getId());
        //			categories.add(categoryServiceResult.getValue());
        //		});
        //		product.setCategories(categories);

        ServiceResult<Product> productServiceResult = save(product);
        if (productServiceResult.isFailed()) {
            jsonResponse.setStatus(HttpStatus.NOT_FOUND.value());
            jsonResponse.setMessage(getMessage("product.has.not.been.saved"));
        }

        return jsonResponse;
    }

    public PageResource<List<SimpleProductResponse>> filter(PageDto<ProductFilterDto> pageDto) {

        if (CollectionUtils.isNotEmpty(pageDto.getFilterDto().getCategoryIds())) {
            //			Long first = pageDto.getFilterDto().getCategoryIds().get(0);
            //			CategoryResponse categoryResponse = CacheUtility.ALL_CATEGORIES_MAP.get(first);
            //			List<Long> childsIdList = categoryResponse.getChildsIdList();
            //			pageDto.getFilterDto().getCategoryIds().addAll(childsIdList);
        }

        Specification<Product> specifications = productQuery.filter(pageDto.getFilterDto());

        ServiceResult<Page<Product>> pageSR = filter(specifications, pageDto);

        Page<Product> pageEntity = (Page) pageSR.getValue();
        List<SimpleProductResponse> pList = new ArrayList<>();

        for (Product product : pageEntity.getContent()) {
            SimpleProductResponse productResponse = productMapper.toSimpleResponse(product);
            pList.add(productResponse);
        }

        PageResource<List<SimpleProductResponse>> pageResource = new PageResource(pageDto.getDraw(), pageEntity.getTotalElements(),
                pageEntity.getTotalElements(), pList);

        return pageResource;
    }

    public JsonResponse<Map<Integer, List<ValidateResult>>> saveProductWithExcelFile(MultipartFile file) {

        JsonResponse<Map<Integer, List<ValidateResult>>> jsonResponse = new JsonResponse<>();

        Workbook workbook = null;
        try {
            //			boolean maxInputSizeExceed = Utils.maxInputSizeExceed(file.getInputStream());
            //			if (maxInputSizeExceed) {
            //				logger.error("max input limit exceed max: {}, input: {}", PropertyUtil.getIntegerValue("config.input.max.size", 10), file.getSize());
            ////				fails.add("<span style=\"color: red;font-size:13px;font-weight: bold;\">"
            ////						+ "<span style=\"font-size:13px;font-weight: bold;\"> Dosya size max limiti aştığı için işleme devam edemiyoruz.");
            ////				fails.add("<br>");
            //				return null;
            //			}
            workbook = new XSSFWorkbook(file.getInputStream());
        } catch (Exception e1) {
            try {
                workbook = new HSSFWorkbook(file.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Product> productRequestList = getExcelProductList(workbook);
        if (CollectionUtils.isEmpty(productRequestList)) {
            jsonResponse.setStatus(HttpStatus.NOT_FOUND.value());
            jsonResponse.setMessage("Excel listesinden herhangi bir ürün oluşturulamadı!");
            return jsonResponse;
        }

        Map<Integer, List<ValidateResult>> validationMap = new LinkedHashMap<>();
        IntStream.range(0, productRequestList.size()).forEach(index -> {
            Product product = productRequestList.get(index);
        });

        //		gelen excel dosyasındaki hataları satıra eklemek için kullanılabilir

        Map<Integer, String> errorMap = new HashMap<>();
        IntStream.range(0, productRequestList.size()).forEach(index -> {
            Product product = productRequestList.get(index);
            JsonResponse<ProductResponse> productResult = saveProduct(product);
            if (productResult.getStatus() != 0) {
                errorMap.put(index + 1, productResult.getMessage());
            }
        });
        //		if (MapUtils.isNotEmpty(errorMap)) {
        //			addErrorsToExcel(workbook, errorMap);
        //			JsonResponse<FileSystemResource> jsonResponse = new JsonResponse<>();
        //			try {
        //				File excelFile = new File(file.getOriginalFilename());
        //				excelFile.createNewFile();
        //				FileOutputStream fos = new FileOutputStream(excelFile);
        //				workbook.write(fos);
        //				fos.close();
        //				jsonResponse.setResult(new FileSystemResource(excelFile));
        //			} catch (Exception e) {
        //				e.printStackTrace();
        //			}
        //			return jsonResponse;
        //		}

        if (MapUtils.isNotEmpty(validationMap)) {
            jsonResponse.setMessage(getMessage("excel.has.errors"));
            jsonResponse.setResult(validationMap);
            return jsonResponse;
        }

        return jsonResponse;
    }


    public void saveRelatedsFromExcel(MultipartFile file) {

        Map<String, List<String>> productNumberMap = new HashMap<>();
        Set<String> uniqueProductNumberList = new HashSet<>();

        try {
            InputStream file1 = file.getInputStream();

            XSSFWorkbook workbook = new XSSFWorkbook(file1);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            rowIterator.next();   //ilk satiri okumasin

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String pId = row.getCell(0).getStringCellValue();
                String rId = row.getCell(1).getStringCellValue();
                System.out.println(pId + " " + rId);

                uniqueProductNumberList.add(pId);
                uniqueProductNumberList.add(rId);

                List<String> idList = productNumberMap.get(pId);

                if (CollectionUtils.isEmpty(idList)) {
                    productNumberMap.put(pId, new ArrayList<>());
                }
                productNumberMap.get(pId).add(rId);


            }
            file1.close();

            //save idlist


            Map<String, Long> clientIdMap = getRepository().findByClientIdMap(uniqueProductNumberList);


            for (Map.Entry<String, List<String>> stringListEntry : productNumberMap.entrySet()) {

                String key = stringListEntry.getKey();
                System.out.println("pId->"+ clientIdMap.get(key));
                for (String s : stringListEntry.getValue()) {

                        try
                        {
                            System.out.println("\trId->"+clientIdMap.get(s));
                            if (clientIdMap.get(key) != null && clientIdMap.get(s) != null) {
                                getRepository().saveProductRelated(Long.valueOf(clientIdMap.get(key)),Long.valueOf(clientIdMap.get(s)));
                            }
                        }catch (Exception e)
                        {
                                throw e;
                        }

                }

            }



        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private List<Product> getExcelProductList(Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.rowIterator();
        boolean first = true;
        List<Product> productRequestList = new ArrayList<>();
        Product product = null;
        while (rows.hasNext()) {
            try {
                Row row = rows.next();
                if (first) {
                    first = false;
                    continue;
                }
                String categoryId = Utils.getCellValue(row, 3, null);
                String stockAmount = Utils.getCellValue(row, 5, null);

                product = new Product();

                if (!StringUtils.isNothing(categoryId)) {
                    Category category = new Category();
                    try {
                        category.setId(Long.valueOf(categoryId));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    //					product.getCategories().add(category);
                }

                //				ProductSaleInfo productSaleInfo = new ProductSaleInfo();
                //				if (!StringUtils.isNothing(stockAmount)) {
                //					productSaleInfo.setStockAmount(new BigDecimal(stockAmount));
                //				}

                productRequestList.add(product);
            } catch (Exception e) {
//                logger.error("Product excel bulk save failed." + e.getMessage(), e);
            }
        }
        return productRequestList;
    }

    @SuppressWarnings("unused")
    private void addErrorsToExcel(Workbook workbook, Map<Integer, String> errorMap) {
        Sheet sheet = workbook.getSheetAt(0);
        errorMap.forEach((key, value) -> {
            int index = 0;
            Iterator<Row> rows = sheet.rowIterator();
            while (rows.hasNext()) {
                Row row = rows.next();
                try {
                    if (key == index++) {
                        row.createCell(4).setCellValue(value);
                    }
                } catch (Exception e) {
//                    logger.error("Product excel errors save failed." + e.getMessage(), e);
                }
            }
        });
    }

    public ServiceResult<Product> findByProductNumber(String productNumber) {
        ServiceResult<Product> serviceResult = new ServiceResult<>();
        Product product = getRepository().findByProductNumber(productNumber);
        if (product == null) {
            serviceResult.setHttpStatus(HttpStatus.NOT_FOUND);
        } else {
            serviceResult.setValue(product);
        }
        return serviceResult;
    }

    public ServiceResult<Product> findByIdNotAndCode(Long id, String productNumber) {
        ServiceResult<Product> serviceResult = new ServiceResult<>();
        Product product = getRepository().findByIdNotAndProductNumber(id, productNumber);
        if (product == null) {
            serviceResult.setHttpStatus(HttpStatus.NOT_FOUND);
        } else {
            serviceResult.setValue(product);
        }
        return serviceResult;

    }

    public void exportExcelTemplate() {

        try {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Excel Import Template");

            String[] headers = new String[]{
                    "code",
                    "serialNo",
                    "brandId",
                    "categoryId",
                    "options",
                    "stockAmount",
                    "priceVal"
            };

            Row row = sheet.createRow(0);
            for (int cn = 0; cn < headers.length; cn++) {
                row.createCell(cn).setCellValue(headers[cn]);
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            writeExcelFileToResponse(response, out, "Excel_Import_Template.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void writeExcelFileToResponse(HttpServletResponse response, ByteArrayOutputStream baos, String filename) throws IOException {
        // Write content type and also length (determined via byte array).
        response.setContentType("application/vnd.ms-excel");
        response.setContentLength(baos.size());
        response.setHeader("Content-disposition", "attachment; filename=" + filename);

        // Flush byte array to servlet output stream.
        ServletOutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
    }
}
