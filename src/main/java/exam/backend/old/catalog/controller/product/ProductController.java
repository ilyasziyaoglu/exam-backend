package exam.backend.old.catalog.controller.product;

import exam.backend.old.catalog.db.entity.product.Product;
import exam.backend.old.catalog.db.mapper.product.ProductMapper;
import exam.backend.old.catalog.db.repository.product.ProductRepository;
import exam.backend.old.catalog.service.product.ProductService;
import exam.backend.common.controller.BaseEntityController;
import exam.backend.common.db.validation.ValidateResult;
import exam.client.catalog.dto.filter.ProductFilterDto;
import exam.client.catalog.dto.request.product.ProductRequest;
import exam.client.catalog.dto.response.product.DistributorResponse;
import exam.client.catalog.dto.response.product.ProductResponse;
import exam.client.catalog.dto.response.product.SimpleProductResponse;
import exam.client.common.dto.pager.PageDto;
import exam.client.common.dto.pager.PageResource;
import exam.client.common.dto.response.JsonResponse;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController extends BaseEntityController<ProductRequest, ProductResponse, Product, ProductRepository, ProductService, ProductMapper> {

	@Resource
	private ProductService productService;

	@Resource
	private ProductMapper productMapper;

	@Override
	protected ProductService getService() {
		return productService;
	}

	@Override
	protected ProductMapper getMapper() {
		return productMapper;
	}

	@GetMapping({"/{id}"})
	public JsonResponse<ProductResponse> get(@PathVariable("id") Long id) {
		JsonResponse<ProductResponse> productResponseJsonResponse = super.get(id);

		ProductResponse productResponse = productResponseJsonResponse.getResult();
		if (productResponse != null) {
//			UserResponse loggedUser = TokenUtils.getLoggedUser(request);

			if (CollectionUtils.isEmpty(productResponse.getDistributors())) {
				DistributorResponse dist = new DistributorResponse();
//				dist.setCompany(loggedUser.getCompany());
				dist.setStock(0);
				dist.setProductId(productResponse.getId());
				productResponse.getDistributors().add(dist);
			}

			Boolean createPage= request.getHeader("referer").contains("/create/");

//			boolean admin = loggedUser.getPermissions().contains("ADMIN");

//			if (createPage &&  !admin) {
//				//remove other distirbutors.
//				Iterator<DistributorResponse> iterator = productResponse.getDistributors().iterator();
//
//				while (iterator.hasNext()) {
//					DistributorResponse dist = iterator.next();
//					if (!dist.getCompany().getId().equals(loggedUser.getCompany().getId())) {
//						iterator.remove();
//					}
//				}
//			}
		}

		return productResponseJsonResponse;
	}

	@ResponseBody
	@PostMapping(value = "/get-by-ids")
	public JsonResponse<List<ProductResponse>> getProductsByIds(@RequestBody List<Long> ids) {

		return getService().getProductsByIds(ids);
	}

	@GetMapping(value = "/excel-template")
	public void getTemplate() {
		getService().exportExcelTemplate();
	}

	@PostMapping(value = "/excel-upload")
	public JsonResponse<Map<Integer, List<ValidateResult>>> getFile(@RequestParam("file0") MultipartFile file) {
		return getService().saveProductWithExcelFile(file);
	}

	@PostMapping(value = "/excel-upload-relateds")
	public JsonResponse uploadRelateds(@RequestParam("file0") MultipartFile file) {
		getService().saveRelatedsFromExcel(file);

		return new JsonResponse();
	}

	@GetMapping(value = "/based-category")
	public void getProductCountBasedCategory() {

	}

	@PostMapping("/filter")
	public JsonResponse<PageResource<List<SimpleProductResponse>>> filter(@RequestBody PageDto<ProductFilterDto> pageDto) {
		JsonResponse json = new JsonResponse();
		PageResource<List<SimpleProductResponse>> filter = getService().filter(pageDto);
		json.setResult(filter);
		return json;
	}

}
