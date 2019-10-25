package exam.backend.catalog.service.product;

import exam.backend.catalog.db.entity.product.ProductFeature;
import exam.backend.catalog.db.mapper.product.ProductFeatureMapper;
import exam.backend.catalog.db.repository.product.ProductFeatureRepository;
import exam.backend.common.service.BaseEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductFeatureService extends BaseEntityService<ProductFeature, ProductFeatureRepository> {

	@Resource
	private ProductFeatureRepository productFeatureRepository;

	@Resource
	private ProductFeatureMapper productFeatureMapper;

	@Override
	public ProductFeatureRepository getRepository() {
		return productFeatureRepository;
	}

	public ProductFeatureMapper getMapper() {
		return productFeatureMapper;
	}
}
