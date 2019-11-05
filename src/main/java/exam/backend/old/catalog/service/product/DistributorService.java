package exam.backend.old.catalog.service.product;

import exam.backend.old.catalog.db.entity.product.Distributor;
import exam.backend.old.catalog.db.repository.product.DistributorRepository;
import exam.backend.common.service.BaseEntityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DistributorService extends BaseEntityService<Distributor, DistributorRepository> {

	@Resource
	private DistributorRepository distributorRepository;

	@Override
	public DistributorRepository getRepository() {
		return distributorRepository;
	}

}
