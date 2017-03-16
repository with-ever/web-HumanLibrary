package kr.withever.humanlibrary.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.mapper.CategoryMapper;

@Repository
public class CategoryRepository {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	public Category retrieveCategory(Long id){
		return this.categoryMapper.selectCategory(id);
	}
	
	public Category retrieveCategoryByCategoryName(String categoryName){
		return this.categoryMapper.selectCategoryByCategoryName(categoryName);
	}
	
	public Long createCategory(Category category){
		this.categoryMapper.insertCategory(category);
		return category.getId();
	}
	
	public void modifyCategory(Category category){
		try {
			this.categoryMapper.updateCategory(category);
		} catch (Exception e) {
			throw new HumanLibraryException(e, ExceptionType.US10000);
		}
	}
	
	public void removeCategory(Long id){
		try {
			this.categoryMapper.deleteCategory(id);
		} catch (Exception e) {
			throw new HumanLibraryException(e, ExceptionType.US10000);
		}
	}
	
	public int countCategory(){
		return this.categoryMapper.countCategory();
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
}
