package exam.backend.catalog.db.mapper.company;

import exam.backend.catalog.db.entity.company.Company;
import exam.client.catalog.dto.request.company.CompanyRequest;
import exam.client.catalog.dto.response.company.CompanyResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-31T23:32:35+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyResponse toResponse(Company entity) {
        if ( entity == null ) {
            return null;
        }

        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setId( entity.getId() );
        companyResponse.setStatus( entity.getStatus() );
        companyResponse.setName( entity.getName() );

        return companyResponse;
    }

    @Override
    public Company toEntity(CompanyRequest request) {
        if ( request == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( request.getId() );
        company.setStatus( request.getStatus() );
        company.setName( request.getName() );

        return company;
    }
}
