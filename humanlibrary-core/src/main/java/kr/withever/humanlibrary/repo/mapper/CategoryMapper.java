package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.humanbook.Category;

public interface CategoryMapper {
	
	Category selectCategory(Long id);
	
	Category selectCategoryByCategoryName(String categoryName);
	
	int insertCategory(Category category);
	
	int updateCategory(Category category);
	
	int deleteCategory(Long id);
	
	int countCategory();
	
}
