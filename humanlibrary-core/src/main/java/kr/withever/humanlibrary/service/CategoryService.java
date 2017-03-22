package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;

public interface CategoryService {
	
	Category retrieveCategory(Long id);
	
	Category retrieveCategoryByCategoryName(String categoryName);
	
	Long createCategory(Category category);
	
	void modifyCategory(Category category);
	
	void removeCategory(Long id);
	
	int countCategory();
	
	CategorySearch retrieveCategoryBySearch(CategorySearch search);
}
