package exam.backend.offers.db.mapper;

import exam.backend.catalog.db.entity.company.Company;
import exam.backend.catalog.db.entity.product.Distributor;
import exam.backend.offers.db.entity.Offer;
import exam.backend.offers.db.entity.OfferHistory;
import exam.client.catalog.dto.request.company.CompanyRequest;
import exam.client.catalog.dto.response.company.CompanyResponse;
import exam.client.catalog.dto.response.product.DistributorResponse;
import exam.client.offer.dto.request.OfferHistoryRequest;
import exam.client.offer.dto.request.OfferRequest;
import exam.client.offer.dto.response.OfferHistoryResponse;
import exam.client.offer.dto.response.OfferResponse;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-25T20:49:54+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class OfferMapperImpl implements OfferMapper {

    @Override
    public OfferResponse toResponse(Offer entity) {
        if ( entity == null ) {
            return null;
        }

        OfferResponse offerResponse = new OfferResponse();

        offerResponse.setId( entity.getId() );
        offerResponse.setGrupId( entity.getGrupId() );
        offerResponse.setAmount( entity.getAmount() );
        offerResponse.setUnitPrice( entity.getUnitPrice() );
        offerResponse.setCurrentStatus( entity.getCurrentStatus() );
        offerResponse.setOfferProductId( entity.getOfferProductId() );
        offerResponse.setUserId( entity.getUserId() );
        offerResponse.setFromCompany( companyToCompanyResponse( entity.getFromCompany() ) );
        offerResponse.setToCompany( companyToCompanyResponse( entity.getToCompany() ) );
        offerResponse.setOfferHistory( offerHistorySetToOfferHistoryResponseSet( entity.getOfferHistory() ) );
        offerResponse.setProductNumber( entity.getProductNumber() );
        offerResponse.setProductName( entity.getProductName() );
        offerResponse.setUserName( entity.getUserName() );
        offerResponse.setCreatedDate( entity.getCreatedDate() );
        offerResponse.setDistributors( distributorSetToDistributorResponseSet( entity.getDistributors() ) );

        return offerResponse;
    }

    @Override
    public Offer toEntity(OfferRequest request) {
        if ( request == null ) {
            return null;
        }

        Offer offer = new Offer();

        offer.setId( request.getId() );
        offer.setGrupId( request.getGrupId() );
        offer.setAmount( request.getAmount() );
        offer.setUnitPrice( request.getUnitPrice() );
        offer.setCurrentStatus( request.getCurrentStatus() );
        offer.setProductId( request.getProductId() );
        offer.setUserId( request.getUserId() );
        offer.setOfferHistory( offerHistoryRequestSetToOfferHistorySet( request.getOfferHistory() ) );
        offer.setFromCompany( companyRequestToCompany( request.getFromCompany() ) );
        offer.setToCompany( companyRequestToCompany( request.getToCompany() ) );

        return offer;
    }

    @Override
    public OfferResponse toSimpleResponse(Offer entity) {
        if ( entity == null ) {
            return null;
        }

        OfferResponse offerResponse = new OfferResponse();

        offerResponse.setId( entity.getId() );
        offerResponse.setGrupId( entity.getGrupId() );
        offerResponse.setAmount( entity.getAmount() );
        offerResponse.setUnitPrice( entity.getUnitPrice() );
        offerResponse.setCurrentStatus( entity.getCurrentStatus() );
        offerResponse.setOfferProductId( entity.getOfferProductId() );
        offerResponse.setUserId( entity.getUserId() );
        offerResponse.setFromCompany( companyToCompanyResponse( entity.getFromCompany() ) );
        offerResponse.setToCompany( companyToCompanyResponse( entity.getToCompany() ) );
        offerResponse.setOfferHistory( offerHistorySetToOfferHistoryResponseSet( entity.getOfferHistory() ) );
        offerResponse.setProductNumber( entity.getProductNumber() );
        offerResponse.setProductName( entity.getProductName() );
        offerResponse.setUserName( entity.getUserName() );
        offerResponse.setCreatedDate( entity.getCreatedDate() );
        offerResponse.setDistributors( distributorSetToDistributorResponseSet( entity.getDistributors() ) );

        return offerResponse;
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

    protected OfferHistoryResponse offerHistoryToOfferHistoryResponse(OfferHistory offerHistory) {
        if ( offerHistory == null ) {
            return null;
        }

        OfferHistoryResponse offerHistoryResponse = new OfferHistoryResponse();

        offerHistoryResponse.setId( offerHistory.getId() );
        offerHistoryResponse.setStatus( offerHistory.getStatus() );
        offerHistoryResponse.setDescription( offerHistory.getDescription() );
        offerHistoryResponse.setDate( offerHistory.getDate() );

        return offerHistoryResponse;
    }

    protected Set<OfferHistoryResponse> offerHistorySetToOfferHistoryResponseSet(Set<OfferHistory> set) {
        if ( set == null ) {
            return null;
        }

        Set<OfferHistoryResponse> set1 = new HashSet<OfferHistoryResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OfferHistory offerHistory : set ) {
            set1.add( offerHistoryToOfferHistoryResponse( offerHistory ) );
        }

        return set1;
    }

    protected DistributorResponse distributorToDistributorResponse(Distributor distributor) {
        if ( distributor == null ) {
            return null;
        }

        DistributorResponse distributorResponse = new DistributorResponse();

        distributorResponse.setId( distributor.getId() );
        distributorResponse.setCompany( companyToCompanyResponse( distributor.getCompany() ) );
        distributorResponse.setStock( distributor.getStock() );
        distributorResponse.setUnitPrice( distributor.getUnitPrice() );

        return distributorResponse;
    }

    protected Set<DistributorResponse> distributorSetToDistributorResponseSet(Set<Distributor> set) {
        if ( set == null ) {
            return null;
        }

        Set<DistributorResponse> set1 = new HashSet<DistributorResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Distributor distributor : set ) {
            set1.add( distributorToDistributorResponse( distributor ) );
        }

        return set1;
    }

    protected OfferHistory offerHistoryRequestToOfferHistory(OfferHistoryRequest offerHistoryRequest) {
        if ( offerHistoryRequest == null ) {
            return null;
        }

        OfferHistory offerHistory = new OfferHistory();

        offerHistory.setId( offerHistoryRequest.getId() );
        offerHistory.setStatus( offerHistoryRequest.getStatus() );
        offerHistory.setDescription( offerHistoryRequest.getDescription() );
        offerHistory.setDate( offerHistoryRequest.getDate() );

        return offerHistory;
    }

    protected Set<OfferHistory> offerHistoryRequestSetToOfferHistorySet(Set<OfferHistoryRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<OfferHistory> set1 = new HashSet<OfferHistory>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( OfferHistoryRequest offerHistoryRequest : set ) {
            set1.add( offerHistoryRequestToOfferHistory( offerHistoryRequest ) );
        }

        return set1;
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
