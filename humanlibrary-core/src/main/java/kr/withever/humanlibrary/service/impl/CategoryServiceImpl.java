package kr.withever.humanlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.CategoryRepository;
import kr.withever.humanlibrary.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public Category retrieveCategory(Long id) {
		Category category = this.categoryRepository.retrieveCategory(id);
		if(category == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(id), "success");
		return category;
	}

	@Override
	public Category retrieveCategoryByCategoryName(String categoryName) {
		Category category = this.categoryRepository.retrieveCategoryByCategoryName(categoryName);
		if(category == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(categoryName), "success");
		return category;
	}

	@Override
	public int insertCategory(Category category) {
		return this.categoryRepository.insertCategory(category);
	}

	@Override
	public int updateCategory(Category category) {
		return this.categoryRepository.updateCategory(category);
	}

	@Override
	public int deleteCategory(Long id) {
		return this.categoryRepository.deleteCategory(id);
	}

	@Override
	public int countCategory() {
		return this.categoryRepository.countCategory();
	}
	
}
