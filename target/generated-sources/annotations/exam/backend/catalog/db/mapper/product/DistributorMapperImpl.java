package exam.backend.catalog.db.mapper.product;

import exam.backend.catalog.db.entity.company.Company;
import exam.backend.catalog.db.entity.product.Distributor;
import exam.client.catalog.dto.request.company.CompanyRequest;
import exam.client.catalog.dto.request.product.DistributorRequest;
import exam.client.catalog.dto.response.company.CompanyResponse;
import exam.client.catalog.dto.response.product.DistributorResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-25T20:49:54+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class DistributorMapperImpl implements DistributorMapper {

    @Override
    public DistributorResponse toResponse(Distributor entity) {
        if ( entity == null ) {
            return null;
        }

        DistributorResponse distributorResponse = new DistributorResponse();

        distributorResponse.setId( entity.getId() );
        distributorResponse.setCompany( companyToCompanyResponse( entity.getCompany() ) );
        distributorResponse.setStock( entity.getStock() );
        distributorResponse.setUnitPrice( entity.getUnitPrice() );

        return distributorResponse;
    }

    @Override
    public Distributor toEntity(DistributorRequest request) {
        if ( request == null ) {
            return null;
        }

        Distributor distributor = new Distributor();

        distributor.setId( request.getId() );
        distributor.setCompany( companyRequestToCompany( request.getCompany() ) );
        distributor.setStock( request.getStock() );
        if ( request.getUnitPrice() != null ) {
            distributor.setUnitPrice( request.getUnitPrice() );
        }

        return distributor;
    }

    protected CompanyResponse companyToCompanyResponse(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setId( company.getId() );
        companyResponse.setStatus( company.getStatus() );
        companyResponse.setName( company.getName() );

        return companyResponse;
    }

    protected Company companyRequestToCompany(CompanyRequest companyRequest) {
        if ( companyRequest == null ) {
            return null;
        }

        Company company = new Company();

        company.setId( companyRequest.getId() );
        company.setStatus( companyRequest.getStatus() );
        company.setName( companyRequest.getName() );

        return company;
    }
}
