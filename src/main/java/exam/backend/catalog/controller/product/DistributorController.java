package exam.backend.catalog.controller.product;

import exam.backend.catalog.db.entity.product.Distributor;
import exam.backend.catalog.db.mapper.product.DistributorMapper;
import exam.backend.catalog.db.repository.product.DistributorRepository;
import exam.backend.catalog.service.product.DistributorService;
import exam.client.catalog.dto.request.product.DistributorRequest;
import exam.client.catalog.dto.response.product.DistributorResponse;
import exam.backend.common.controller.BaseEntityController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/distributor")
public class DistributorController
		extends BaseEntityController<DistributorRequest, DistributorResponse, Distributor, DistributorRepository, DistributorService, DistributorMapper> {

	@Resource
	private DistributorService distrubutorService;

	@Resource
	private DistributorMapper distrubutorMapper;

	@Override
	protected DistributorService getService() {
		return distrubutorService;
	}

	@Override
	protected DistributorMapper getMapper() {
		return distrubutorMapper;
	}
}
