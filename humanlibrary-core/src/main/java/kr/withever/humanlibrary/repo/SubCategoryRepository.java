package kr.withever.humanlibrary.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.domain.humanbook.SubCategorySearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.mapper.SubCategoryMapper;

@Repository
public class SubCategoryRepository {
	
	@Autowired
	private SubCategoryMapper subCategoryMapper;

	public SubCategory retrieveSubCategory(Long id){
		return this.subCategoryMapper.selectSubCategory(id);
	}
	
	public SubCategory retrieveSubCategoryByCategoryName(String categoryName){
		return this.subCategoryMapper.selectSubCategoryByCategoryName(categoryName);
	}
	
	public Long createSubCategory(SubCategory subCategory){
		this.subCategoryMapper.insertSubCategory(subCategory);
		return subCategory.getId();
	}
	
	public void modifySubCategory(SubCategory subCategory){
		try {
			this.subCategoryMapper.updateSubCategory(subCategory);
		} catch (Exception e) {
			// @TODO exception 코드 정리 필요.
			throw new HumanLibraryException(e, ExceptionType.US_500_001);
		}
	}
	
	public void removeSubCategory(Long id){
		try {
			this.subCategoryMapper.deleteSubCategory(id);
		} catch (Exception e) {
			// @TODO exception 코드 정리 필요.
			throw new HumanLibraryException(e, ExceptionType.US_500_001);
		}
	}
	
	public SubCategorySearch retrieveSubCategoriesBySearch(SubCategorySearch search){
		List<SubCategory> subCategories = this.subCategoryMapper.selectSubCategoriesBySearch(search);
		search.setResults(subCategories);
		if(subCategories.size() != 0){
			int totalCount = this.subCategoryMapper.selectSubCategoriesTotalCountBySearch(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}

}
