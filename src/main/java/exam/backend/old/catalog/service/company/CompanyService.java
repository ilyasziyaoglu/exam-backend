package exam.backend.old.catalog.service.company;

import exam.backend.old.catalog.db.entity.company.Company;
import exam.backend.old.catalog.db.repository.company.CompanyRepository;
import exam.backend.common.service.BaseEntityService;
import exam.backend.common.service.ServiceResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.ZonedDateTime;

@Service
public class CompanyService extends BaseEntityService<Company, CompanyRepository> {

	@Resource
	private CompanyRepository companyRepositoryRepository;


	@Override
	public ServiceResult<Company> save(Company entity) {
		entity.setCreatedBy("test");
		entity.setCreatedDate(ZonedDateTime.now());
		return super.save(entity);
	}

	@Override
	public CompanyRepository getRepository() {
		return companyRepositoryRepository;
	}
}
