package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.Category;

public interface CategoryService {
	
	Category selectCategory(Long id);
	
	Category selectCategoryByCategoryName(String categoryName);
	
	int insertCategory(Category category);
	
	int updateCategory(Category category);
	
	int deleteCategory(Long id);
	
	int countCategory();
}
