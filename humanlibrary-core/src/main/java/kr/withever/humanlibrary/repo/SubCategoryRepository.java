package kr.withever.humanlibrary.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.humanbook.SubCategory;
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
	
	public int insertSubCategory(SubCategory subCategory){
		try {
			this.subCategoryMapper.insertSubCategory(subCategory);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int updateSubCategory(SubCategory subCategory){
		try {
			this.subCategoryMapper.updateSubCategory(subCategory);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int deleteSubCategory(Long id){
		try {
			this.subCategoryMapper.deleteSubCategory(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

}
