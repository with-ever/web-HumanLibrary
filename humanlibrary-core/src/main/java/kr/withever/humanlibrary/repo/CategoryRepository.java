package kr.withever.humanlibrary.repo;

import java.util.ArrayList;
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
	
	
	public Long createCategory(Category category){
		this.categoryMapper.insertCategory(category);
		return category.getId();
	}

	public Category retrieveCategory(Long id){
		Category category = this.categoryMapper.selectCategory(id);
		if (category != null) setSubCategoriesInCategory(category);
		return category;
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

	public List<Category> retrieveCategoriesWithSubCategory() {
		List<Category> allCategories = this.categoryMapper.selectCategories();
		List<Category> parentCategories = new ArrayList<>();
		if (allCategories.size() != 0) {
			for (Category category : allCategories) {
				if(category.getParentCategoryId() == null){
					setSubCategoriesInCategory(category);
					parentCategories.add(category);
				}
			}
		}
		return parentCategories;
	}
	
	private void setSubCategoriesInCategory(Category category){
		List<Category> allSubCategories = this.categoryMapper.selectCategories();
		List<Category> addedSubCategories = new ArrayList<Category>();
		for (Category currentCategory : allSubCategories) {
			if (category.getId() == currentCategory.getParentCategoryId()) addedSubCategories.add(currentCategory);
		}
		category.setSubCategories(addedSubCategories);
	}
}
