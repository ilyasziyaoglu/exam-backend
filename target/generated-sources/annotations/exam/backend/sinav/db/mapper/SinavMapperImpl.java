package exam.backend.sinav.db.mapper;

import exam.backend.catalog.db.entity.company.Company;
import exam.backend.sinav.db.entity.Sinav;
import exam.client.catalog.dto.response.company.CompanyResponse;
import exam.client.sinav.dto.request.SinavRequest;
import exam.client.sinav.dto.response.SinavResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-31T23:32:35+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class SinavMapperImpl implements SinavMapper {

    @Override
    public SinavResponse toResponse(Sinav entity) {
        if ( entity == null ) {
            return null;
        }

        SinavResponse sinavResponse = new SinavResponse();

        sinavResponse.setId( entity.getId() );
        sinavResponse.setName( entity.getName() );
        sinavResponse.setDescription( entity.getDescription() );
        sinavResponse.setDate( entity.getDate() );
        sinavResponse.setCompany( companyToCompanyResponse( entity.getCompany() ) );
        sinavResponse.setRegisteredCount( entity.getRegisteredCount() );
        sinavResponse.setQuestionCoun( entity.getQuestionCoun() );
        sinavResponse.setType( entity.getType() );

        return sinavResponse;
    }

    @Override
    public Sinav toEntity(SinavRequest request) {
        if ( request == null ) {
            return null;
        }

        Sinav sinav = new Sinav();

        sinav.setId( request.getId() );
        sinav.setName( request.getName() );
        sinav.setDescription( request.getDescription() );
        sinav.setDate( request.getDate() );
        sinav.setRegisteredCount( request.getRegisteredCount() );
        sinav.setQuestionCoun( request.getQuestionCoun() );
        sinav.setType( request.getType() );

        return sinav;
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
}
