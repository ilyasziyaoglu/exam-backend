package exam.backend.catalog.db.repository.category;

import exam.backend.catalog.db.entity.category.Category;
import exam.backend.common.db.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends BaseRepository<Category> {

	List<Category> findByParentNull();

	Category findCategoryByName(String name);

}
