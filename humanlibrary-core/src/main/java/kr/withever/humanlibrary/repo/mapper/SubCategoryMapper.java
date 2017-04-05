package kr.withever.humanlibrary.repo.mapper;

import java.util.List;

import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.domain.humanbook.SubCategorySearch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubCategoryMapper {
	
	int insertSubCategory(SubCategory subCategory);
	
	SubCategory selectSubCategory(Long id);
	
	SubCategory selectSubCategoryByCategoryName(String categoryName);
	
	List<SubCategory> selectSubCategories();
	
	List<SubCategory> selectSubCategoriesBySearch(SubCategorySearch search);
	
	int selectSubCategoriesTotalCountBySearch(SubCategorySearch search);
	
	int updateSubCategory(SubCategory subCategory);
	
	int deleteSubCategory(Long id);
	
	int countSubCategory();
	
}
