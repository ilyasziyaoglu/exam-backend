package exam.backend.catalog.service.product;

import exam.backend.catalog.db.entity.product.Feature;
import exam.backend.catalog.db.mapper.product.FeatureMapper;
import exam.backend.catalog.db.repository.product.FeatureRepository;
import exam.backend.common.service.BaseEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class FeatureService extends BaseEntityService<Feature, FeatureRepository> {

	@Resource
	private FeatureRepository featureRepository;

	@Resource
	private FeatureMapper featureMapper;

	@Override
	public FeatureRepository getRepository() {
		return featureRepository;
	}

	public FeatureMapper getMapper() {
		return featureMapper;
	}
}
