package kr.withever.humanlibrary.repo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.mapper.CategoryMapper;
import kr.withever.humanlibrary.repo.mapper.SubCategoryMapper;

@Repository
public class CategoryRepository {
	
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private SubCategoryMapper subCategoryMapper;
	
	
	public Long createCategory(Category category){
		this.categoryMapper.insertCategory(category);
		return category.getId();
	}

	public Category retrieveCategory(Long id){
		Category category = this.categoryMapper.selectCategory(id);
		List<SubCategory> childCategoryList = this.subCategoryMapper.selectSubCategories();
		for (int i=childCategoryList.size()-1 ; i>=0 ; i--) {
			if(childCategoryList.get(i).getParentCategoryId() != id){
				childCategoryList.remove(i);
			}
		}
		category.setChildCategories(childCategoryList);
		return category;
	}
	
	public Category retrieveCategoryByCategoryName(String categoryName){
		return this.categoryMapper.selectCategoryByCategoryName(categoryName);
	}
	
	public CategorySearch retrieveCategoryBySearch(CategorySearch search){
		List<Category> categories = this.categoryMapper.selectCategoriesBySearch(search);
		search.setResults(categories);
		if(categories.size() != 0){
			int totalCount = this.categoryMapper.selectCategoriesTotalCountBySearch(search);
			search.setTotalCount(totalCount);
		}
		return search;
	}
	
	public void modifyCategory(Category category){
		try {
			this.categoryMapper.updateCategory(category);
		} catch (Exception e) {
			throw new HumanLibraryException(e, ExceptionType.US_500_001);
		}
	}
	
	public void removeCategory(Long id){
		try {
			this.categoryMapper.deleteCategory(id);
		} catch (Exception e) {
			throw new HumanLibraryException(e, ExceptionType.US_500_001);
		}
	}
	
	public int countCategory(){
		return this.categoryMapper.countCategory();
	}
}
