package exam.backend.catalog.db.mapper.product;

import exam.backend.catalog.db.entity.product.Feature;
import exam.client.catalog.dto.request.product.FeatureRequest;
import exam.client.catalog.dto.response.product.FeatureResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-31T23:32:35+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 12.0.2 (Oracle Corporation)"
)
@Component
public class FeatureMapperImpl implements FeatureMapper {

    @Override
    public FeatureResponse toResponse(Feature entity) {
        if ( entity == null ) {
            return null;
        }

        FeatureResponse featureResponse = new FeatureResponse();

        featureResponse.setId( entity.getId() );
        featureResponse.setKey( entity.getKey() );
        featureResponse.setName( entity.getName() );

        return featureResponse;
    }

    @Override
    public Feature toEntity(FeatureRequest request) {
        if ( request == null ) {
            return null;
        }

        Feature feature = new Feature();

        feature.setId( request.getId() );
        feature.setKey( request.getKey() );
        feature.setName( request.getName() );

        return feature;
    }
}
