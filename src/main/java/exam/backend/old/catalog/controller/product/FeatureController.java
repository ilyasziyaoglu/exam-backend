package exam.backend.old.catalog.controller.product;

import exam.backend.old.catalog.db.entity.product.Feature;
import exam.backend.old.catalog.db.mapper.product.FeatureMapper;
import exam.backend.old.catalog.db.repository.product.FeatureRepository;
import exam.backend.old.catalog.service.product.FeatureService;
import exam.client.catalog.dto.request.product.FeatureRequest;
import exam.client.catalog.dto.response.product.FeatureResponse;
import exam.backend.common.controller.BaseEntityController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feature")
public class FeatureController extends BaseEntityController<FeatureRequest, FeatureResponse, Feature, FeatureRepository, FeatureService, FeatureMapper>{

	@Resource
	private FeatureService featureTypeService;

	@Resource
	private FeatureMapper featureMapper;

	@Override
	protected FeatureService getService() {
		return this.featureTypeService;
	}

	@Override
	protected FeatureMapper getMapper() {
		return this.featureMapper;
	}
}
