package kr.withever.humanlibrary.repo.mapper;

import java.util.List;

import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.domain.humanbook.SubCategorySearch;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubCategoryMapper {
	
	SubCategory selectSubCategory(Long id);
	
	SubCategory selectSubCategoryByCategoryName(String categoryName);
	
	int insertSubCategory(SubCategory subCategory);
	
	int updateSubCategory(SubCategory subCategory);
	
	int deleteSubCategory(Long id);
	
	int countSubCategory();
	
	Long selectParentCategoryIdByName(String categoryName);
	
	List<SubCategory> selectSubCategoriesBySearch(SubCategorySearch search);
	
	List<SubCategory> selectChildCategoriesBySearch(SubCategorySearch search);
	
	int selectSubCategoriesTotalCountBySearch(SubCategorySearch search);
}
