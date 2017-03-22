package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.domain.humanbook.SubCategorySearch;

public interface SubCategoryService {
	
	SubCategory retrieveSubCategory(Long id);
	
	SubCategory retrieveSubCategoryByCategoryName(String categoryName);
	
	Long createSubCategory(SubCategory subCategory);
	
	void modifySubCategory(SubCategory subCategory);
	
	void removeSubCategory(Long id);
	
	SubCategorySearch retrieveSubCategoriesBySearch(SubCategorySearch search);
}
