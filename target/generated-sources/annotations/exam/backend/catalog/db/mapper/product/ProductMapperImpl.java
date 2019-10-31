package exam.backend.catalog.db.mapper.product;

import exam.backend.catalog.db.entity.company.Company;
import exam.backend.catalog.db.entity.product.Distributor;
import exam.backend.catalog.db.entity.product.Feature;
import exam.backend.catalog.db.entity.product.Product;
import exam.backend.catalog.db.entity.product.ProductFeature;
import exam.client.catalog.dto.request.company.CompanyRequest;
import exam.client.catalog.dto.request.product.DistributorRequest;
import exam.client.catalog.dto.request.product.FeatureRequest;
import exam.client.catalog.dto.request.product.ProductFeatureRequest;
import exam.client.catalog.dto.request.product.ProductRequest;
import exam.client.catalog.dto.response.company.CompanyResponse;
import exam.client.catalog.dto.response.product.DistributorResponse;
import exam.client.catalog.dto.response.product.FeatureResponse;
import exam.client.catalog.dto.response.product.ProductFeatureResponse;
import exam.client.catalog.dto.response.product.ProductResponse;
import exam.client.catalog.dto.response.product.SimpleProductResponse;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-31T23:32:35+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductResponse toResponse(Product entity) {
        if ( entity == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setId( entity.getId() );
        productResponse.setName( entity.getName() );
        productResponse.setDescription( entity.getDescription() );
        productResponse.setStatus( entity.getStatus() );
        productResponse.setProductNumber( entity.getProductNumber() );
        productResponse.setProducer( entity.getProducer() );
        productResponse.setProductId( entity.getProductId() );
        productResponse.setCategoryId( entity.getCategoryId() );
        productResponse.setProductType( entity.getProductType() );
        productResponse.setProductTypeDesc( entity.getProductTypeDesc() );
        productResponse.setNote( entity.getNote() );
        productResponse.setOwner( companyToCompanyResponse( entity.getOwner() ) );
        productResponse.setManualCreated( entity.getManualCreated() );
        productResponse.setDistributors( distributorSetToDistributorResponseSet( entity.getDistributors() ) );
        productResponse.setProductFeatures( productFeatureSetToProductFeatureResponseSet( entity.getProductFeatures() ) );
        Set<Long> set2 = entity.getRelatedProducts();
        if ( set2 != null ) {
            productResponse.setRelatedProducts( new HashSet<Long>( set2 ) );
        }
        else {
            productResponse.setRelatedProducts( null );
        }
        Set<Long> set3 = entity.getSimilarProducts();
        if ( set3 != null ) {
            productResponse.setSimilarProducts( new HashSet<Long>( set3 ) );
        }
        else {
            productResponse.setSimilarProducts( null );
        }
        Set<String> set4 = entity.getImages();
        if ( set4 != null ) {
            productResponse.setImages( new HashSet<String>( set4 ) );
        }
        else {
            productResponse.setImages( null );
        }

        return productResponse;
    }

    @Override
    public Product toEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( request.getId() );
        product.setName( request.getName() );
        product.setDescription( request.getDescription() );
        product.setProductNumber( request.getProductNumber() );
        product.setProducer( request.getProducer() );
        product.setProductId( request.getProductId() );
        product.setCategoryId( request.getCategoryId() );
        product.setProductType( request.getProductType() );
        product.setProductTypeDesc( request.getProductTypeDesc() );
        product.setNote( request.getNote() );
        product.setStatus( request.getStatus() );
        product.setDistributors( distributorRequestSetToDistributorSet( request.getDistributors() ) );
        product.setProductFeatures( productFeatureRequestSetToProductFeatureSet( request.getProductFeatures() ) );
        Set<Long> set2 = request.getRelatedProducts();
        if ( set2 != null ) {
            product.setRelatedProducts( new HashSet<Long>( set2 ) );
        }
        else {
            product.setRelatedProducts( null );
        }
        Set<Long> set3 = request.getSimilarProducts();
        if ( set3 != null ) {
            product.setSimilarProducts( new HashSet<Long>( set3 ) );
        }
        else {
            product.setSimilarProducts( null );
        }
        Set<String> set4 = request.getImages();
        if ( set4 != null ) {
            product.setImages( new HashSet<String>( set4 ) );
        }
        else {
            product.setImages( null );
        }

        return product;
    }

    @Override
    public SimpleProductResponse toSimpleResponse(Product entity) {
        if ( entity == null ) {
            return null;
        }

        SimpleProductResponse simpleProductResponse = new SimpleProductResponse();

        simpleProductResponse.setId( entity.getId() );
        simpleProductResponse.setProductNumber( entity.getProductNumber() );
        simpleProductResponse.setName( entity.getName() );
        simpleProductResponse.setDescription( entity.getDescription() );
        simpleProductResponse.setCategoryId( entity.getCategoryId() );
        simpleProductResponse.setProducer( entity.getProducer() );
        simpleProductResponse.setDistributors( distributorSetToDistributorResponseSet( entity.getDistributors() ) );

        return simpleProductResponse;
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

    protected FeatureResponse featureToFeatureResponse(Feature feature) {
        if ( feature == null ) {
            return null;
        }

        FeatureResponse featureResponse = new FeatureResponse();

        featureResponse.setId( feature.getId() );
        featureResponse.setKey( feature.getKey() );
        featureResponse.setName( feature.getName() );

        return featureResponse;
    }

    protected ProductFeatureResponse productFeatureToProductFeatureResponse(ProductFeature productFeature) {
        if ( productFeature == null ) {
            return null;
        }

        ProductFeatureResponse productFeatureResponse = new ProductFeatureResponse();

        productFeatureResponse.setId( productFeature.getId() );
        productFeatureResponse.setFeature( featureToFeatureResponse( productFeature.getFeature() ) );
        productFeatureResponse.setValue( productFeature.getValue() );

        return productFeatureResponse;
    }

    protected Set<ProductFeatureResponse> productFeatureSetToProductFeatureResponseSet(Set<ProductFeature> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductFeatureResponse> set1 = new HashSet<ProductFeatureResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductFeature productFeature : set ) {
            set1.add( productFeatureToProductFeatureResponse( productFeature ) );
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

    protected Distributor distributorRequestToDistributor(DistributorRequest distributorRequest) {
        if ( distributorRequest == null ) {
            return null;
        }

        Distributor distributor = new Distributor();

        distributor.setId( distributorRequest.getId() );
        distributor.setCompany( companyRequestToCompany( distributorRequest.getCompany() ) );
        distributor.setStock( distributorRequest.getStock() );
        if ( distributorRequest.getUnitPrice() != null ) {
            distributor.setUnitPrice( distributorRequest.getUnitPrice() );
        }

        return distributor;
    }

    protected Set<Distributor> distributorRequestSetToDistributorSet(Set<DistributorRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<Distributor> set1 = new HashSet<Distributor>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( DistributorRequest distributorRequest : set ) {
            set1.add( distributorRequestToDistributor( distributorRequest ) );
        }

        return set1;
    }

    protected Feature featureRequestToFeature(FeatureRequest featureRequest) {
        if ( featureRequest == null ) {
            return null;
        }

        Feature feature = new Feature();

        feature.setId( featureRequest.getId() );
        feature.setKey( featureRequest.getKey() );
        feature.setName( featureRequest.getName() );

        return feature;
    }

    protected ProductFeature productFeatureRequestToProductFeature(ProductFeatureRequest productFeatureRequest) {
        if ( productFeatureRequest == null ) {
            return null;
        }

        ProductFeature productFeature = new ProductFeature();

        productFeature.setId( productFeatureRequest.getId() );
        productFeature.setFeature( featureRequestToFeature( productFeatureRequest.getFeature() ) );
        productFeature.setValue( productFeatureRequest.getValue() );

        return productFeature;
    }

    protected Set<ProductFeature> productFeatureRequestSetToProductFeatureSet(Set<ProductFeatureRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProductFeature> set1 = new HashSet<ProductFeature>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( ProductFeatureRequest productFeatureRequest : set ) {
            set1.add( productFeatureRequestToProductFeature( productFeatureRequest ) );
        }

        return set1;
    }
}
