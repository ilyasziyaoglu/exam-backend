package exam.backend.catalog.db.mapper.category;

import exam.backend.catalog.db.entity.category.Category;
import exam.client.catalog.dto.request.category.CategoryRequest;
import exam.client.catalog.dto.response.category.CategoryResponse;
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
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryResponse toResponse(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryResponse categoryResponse = new CategoryResponse();

        categoryResponse.setId( entity.getId() );
        categoryResponse.setStatus( entity.getStatus() );
        categoryResponse.setName( entity.getName() );
        categoryResponse.setDescription( entity.getDescription() );
        categoryResponse.setParentId( entity.getParentId() );
        categoryResponse.setLevel( entity.getLevel() );
        categoryResponse.setChildren( categorySetToCategoryResponseSet( entity.getChildren() ) );

        return categoryResponse;
    }

    @Override
    public Category toEntity(CategoryRequest request) {
        if ( request == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( request.getId() );
        category.setParentId( request.getParentId() );
        category.setName( request.getName() );
        category.setDescription( request.getDescription() );
        category.setLevel( request.getLevel() );
        category.setStatus( request.getStatus() );
        category.setChildren( categoryRequestSetToCategorySet( request.getChildren() ) );

        return category;
    }

    protected Set<CategoryResponse> categorySetToCategoryResponseSet(Set<Category> set) {
        if ( set == null ) {
            return null;
        }

        Set<CategoryResponse> set1 = new HashSet<CategoryResponse>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Category category : set ) {
            set1.add( toResponse( category ) );
        }

        return set1;
    }

    protected Set<Category> categoryRequestSetToCategorySet(Set<CategoryRequest> set) {
        if ( set == null ) {
            return null;
        }

        Set<Category> set1 = new HashSet<Category>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( CategoryRequest categoryRequest : set ) {
            set1.add( toEntity( categoryRequest ) );
        }

        return set1;
    }
}
