package exam.backend.old.catalog.controller.company;


import exam.backend.old.catalog.db.entity.company.Company;
import exam.backend.old.catalog.db.mapper.company.CompanyMapper;
import exam.backend.old.catalog.db.repository.company.CompanyRepository;
import exam.backend.old.catalog.service.company.CompanyService;
import exam.client.catalog.dto.request.company.CompanyRequest;
import exam.client.catalog.dto.response.company.CompanyResponse;
import exam.backend.common.controller.BaseEntityController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/company")
public class CompanyController
		extends BaseEntityController<CompanyRequest, CompanyResponse, Company, CompanyRepository, CompanyService, CompanyMapper> {

	@Resource
	private CompanyService companyService;

	@Resource
	private CompanyMapper companyMapper;


	@Override
	protected CompanyService getService() {
		return companyService;
	}

	@Override
	protected CompanyMapper getMapper() {
		return companyMapper;
	}
}
