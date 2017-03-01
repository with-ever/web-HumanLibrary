package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.SubCategory;

public interface SubCategoryService {
	
	SubCategory retrieveSubCategory(Long id);
	
	SubCategory retrieveSubCategoryByCategoryName(String categoryName);
	
	int insertSubCategory(SubCategory subCategory);
	
	int updateSubCategory(SubCategory subCategory);
	
	int deleteSubCategory(Long id);
}
