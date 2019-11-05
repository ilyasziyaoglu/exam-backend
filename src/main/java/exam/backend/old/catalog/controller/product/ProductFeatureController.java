package exam.backend.old.catalog.controller.product;

import exam.backend.old.catalog.db.entity.product.ProductFeature;
import exam.backend.old.catalog.db.mapper.product.ProductFeatureMapper;
import exam.backend.old.catalog.db.repository.product.ProductFeatureRepository;
import exam.backend.old.catalog.service.product.ProductFeatureService;
import exam.client.catalog.dto.request.product.ProductFeatureRequest;
import exam.client.catalog.dto.response.product.ProductFeatureResponse;
import exam.backend.common.controller.BaseEntityController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product-feature")
public class ProductFeatureController extends BaseEntityController<ProductFeatureRequest, ProductFeatureResponse, ProductFeature, ProductFeatureRepository, ProductFeatureService, ProductFeatureMapper>{

	@Resource
	private ProductFeatureService productFeatureService;

	@Resource
	private ProductFeatureMapper productFeatureMapper;

	@Override
	protected ProductFeatureService getService() {
		return this.productFeatureService;
	}

	@Override
	protected ProductFeatureMapper getMapper() {
		return this.productFeatureMapper;
	}
}
