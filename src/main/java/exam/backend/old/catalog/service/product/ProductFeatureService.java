package exam.backend.old.catalog.service.product;

import exam.backend.old.catalog.db.entity.product.ProductFeature;
import exam.backend.old.catalog.db.mapper.product.ProductFeatureMapper;
import exam.backend.old.catalog.db.repository.product.ProductFeatureRepository;
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
