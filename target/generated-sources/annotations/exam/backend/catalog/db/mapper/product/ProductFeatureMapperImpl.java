package exam.backend.catalog.db.mapper.product;

import exam.backend.catalog.db.entity.product.Feature;
import exam.backend.catalog.db.entity.product.ProductFeature;
import exam.client.catalog.dto.request.product.FeatureRequest;
import exam.client.catalog.dto.request.product.ProductFeatureRequest;
import exam.client.catalog.dto.response.product.FeatureResponse;
import exam.client.catalog.dto.response.product.ProductFeatureResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-31T23:32:35+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class ProductFeatureMapperImpl implements ProductFeatureMapper {

    @Override
    public ProductFeatureResponse toResponse(ProductFeature entity) {
        if ( entity == null ) {
            return null;
        }

        ProductFeatureResponse productFeatureResponse = new ProductFeatureResponse();

        productFeatureResponse.setId( entity.getId() );
        productFeatureResponse.setFeature( featureToFeatureResponse( entity.getFeature() ) );
        productFeatureResponse.setValue( entity.getValue() );

        return productFeatureResponse;
    }

    @Override
    public ProductFeature toEntity(ProductFeatureRequest request) {
        if ( request == null ) {
            return null;
        }

        ProductFeature productFeature = new ProductFeature();

        productFeature.setId( request.getId() );
        productFeature.setFeature( featureRequestToFeature( request.getFeature() ) );
        productFeature.setValue( request.getValue() );

        return productFeature;
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
}
