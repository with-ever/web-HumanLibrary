package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.Category;

public interface CategoryService {
	
	Category retrieveCategory(Long id);
	
	Category retrieveCategoryByCategoryName(String categoryName);
	
	int insertCategory(Category category);
	
	int updateCategory(Category category);
	
	int deleteCategory(Long id);
	
	int countCategory();
}
