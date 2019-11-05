package exam.backend.old.catalog.db.mapper.product;

import exam.backend.old.catalog.db.entity.product.Feature;
import exam.client.catalog.dto.request.product.FeatureRequest;
import exam.client.catalog.dto.response.product.FeatureResponse;
import exam.backend.common.db.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeatureMapper extends BaseMapper<Feature, FeatureRequest, FeatureResponse> {
}
