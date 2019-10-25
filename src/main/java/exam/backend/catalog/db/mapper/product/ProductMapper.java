package exam.backend.catalog.db.mapper.product;

import exam.backend.catalog.db.entity.product.Product;
import exam.client.catalog.dto.request.product.ProductRequest;
import exam.client.catalog.dto.response.product.ProductResponse;
import exam.client.catalog.dto.response.product.SimpleProductResponse;
import exam.backend.common.db.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<Product, ProductRequest, ProductResponse> {

	SimpleProductResponse toSimpleResponse(Product entity);
}
