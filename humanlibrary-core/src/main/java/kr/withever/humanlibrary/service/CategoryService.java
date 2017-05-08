package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;

import java.util.List;

public interface CategoryService {
	
	Category retrieveCategory(Long id);
	
	Long createCategory(Category category);
	
	void modifyCategory(Category category);
	
	void removeCategory(Long id);
	
	int countCategory();
	
	CategorySearch retrieveCategoryBySearch(CategorySearch search);

	List<Category> retrieveCategoriesWithSubCategory();
}
