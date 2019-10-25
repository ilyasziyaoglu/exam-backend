package exam.backend.catalog.db.mapper.product;

import exam.backend.catalog.db.entity.product.ProductFeature;
import exam.client.catalog.dto.request.product.ProductFeatureRequest;
import exam.client.catalog.dto.response.product.ProductFeatureResponse;
import exam.backend.common.db.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductFeatureMapper extends BaseMapper<ProductFeature, ProductFeatureRequest, ProductFeatureResponse> {
}
