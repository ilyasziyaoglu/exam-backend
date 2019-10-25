package exam.backend.catalog.db.repository.company;

import exam.backend.catalog.db.entity.company.Company;
import exam.backend.common.db.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends BaseRepository<Company> {

	public Company findCompanyByName(String name);
}
