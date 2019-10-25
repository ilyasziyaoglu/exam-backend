package exam.backend.catalog.service.category;

import exam.backend.catalog.db.entity.category.Category;
import exam.backend.catalog.db.mapper.category.CategoryMapper;
import exam.backend.catalog.db.repository.category.CategoryRepository;
import exam.backend.common.service.BaseEntityService;
import exam.backend.common.service.ServiceResult;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CategoryService extends BaseEntityService<Category, CategoryRepository> {

	@Resource
	private CategoryRepository categoryRepository;

	@Resource
	private CategoryMapper categoryMapper;

	@Override
	public CategoryRepository getRepository() {
		return categoryRepository;
	}

	@Override
	public ServiceResult<Category> save(Category entity) {

		Optional<Category> parent = getRepository().findById(entity.getParentId());
		if (parent.isPresent()) {
			entity.setParent(parent.get());
			Category save = getRepository().saveAndFlush(entity);
			return new ServiceResult<>(HttpStatus.OK, save);
		}

		return new ServiceResult<>(HttpStatus.NOT_FOUND);
	}

//	public void reloadCategories() {
//		CacheUtility.ALL_CATEGORIES.clear();
//		List<Category> categoryList = categoryRepository.findByParentNull();
//		for (Category category : categoryList) {
//			CategoryResponse categoryResponse = categoryMapper.toResponse(category);
//			CacheUtility.ALL_CATEGORIES.add(categoryResponse);
//		}
//
//	}

}
