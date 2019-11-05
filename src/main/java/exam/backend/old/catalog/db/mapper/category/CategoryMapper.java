package exam.backend.old.catalog.db.mapper.category;

import exam.backend.old.catalog.db.entity.category.Category;
import exam.client.catalog.dto.request.category.CategoryRequest;
import exam.client.catalog.dto.response.category.CategoryResponse;
import exam.backend.common.db.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryRequest, CategoryResponse> {

}
