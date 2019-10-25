package exam.backend.catalog.controller.category;

import exam.backend.catalog.db.entity.category.Category;
import exam.backend.catalog.db.mapper.category.CategoryMapper;
import exam.backend.catalog.db.repository.category.CategoryRepository;
import exam.backend.catalog.service.category.CategoryService;
import exam.backend.common.controller.BaseEntityController;
import exam.client.catalog.dto.request.category.CategoryRequest;
import exam.client.catalog.dto.response.category.CategoryResponse;
import exam.client.common.dto.response.JsonResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/category")
public class CategoryController
		extends BaseEntityController<CategoryRequest, CategoryResponse, Category, CategoryRepository, CategoryService, CategoryMapper> {

	@Resource
	private CategoryService categoryService;

	@Resource
	private CategoryMapper categoryMapper;

	@Override
	protected CategoryService getService() {
		return categoryService;
	}

	@Override
	protected CategoryMapper getMapper() {
		return categoryMapper;
	}

	@PostMapping
	public JsonResponse<CategoryResponse> post(@RequestBody CategoryRequest request) {

		JsonResponse<CategoryResponse> post = super.post(request);
//		getService().reloadCategories();

		return post;
	}
}
