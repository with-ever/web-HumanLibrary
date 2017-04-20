package kr.withever.humanlibrary.repo;

import java.util.ArrayList;
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
		if (category != null) setSubCategoryInCategory(category);
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

	public List<Category> retrieveCategoriesWithSubCategory() {
		List<Category> categories = this.categoryMapper.selectCategories();
		if (categories.size() != 0) {
			for (Category category : categories) {
				setSubCategoryInCategory(category);
			}
		}
		return categories;
	}
	
	private void setSubCategoryInCategory(Category category){
		List<SubCategory> subCategories = this.subCategoryMapper.selectSubCategories();
		List<SubCategory> addedSubCategories = new ArrayList<SubCategory>();
		for (SubCategory subCategory : subCategories) {
			if (category.getId() == subCategory.getParentCategoryId()) addedSubCategories.add(subCategory);
		}
		category.setSubCategories(addedSubCategories);
	}
}
