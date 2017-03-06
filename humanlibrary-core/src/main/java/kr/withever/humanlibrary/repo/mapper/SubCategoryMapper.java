package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.humanbook.SubCategory;

public interface SubCategoryMapper {
	
	SubCategory selectSubCategory(Long id);
	
	SubCategory selectSubCategoryByCategoryName(String categoryName);
	
	int insertSubCategory(SubCategory subCategory);
	
	int updateSubCategory(SubCategory subCategory);
	
	int deleteSubCategory(Long id);
	
	int countSubCategory();
}
