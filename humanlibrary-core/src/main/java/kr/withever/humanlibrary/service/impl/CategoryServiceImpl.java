package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.exception.HumanLibraryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.CategoryRepository;
import kr.withever.humanlibrary.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public Category retrieveCategory(Long id) {
		Category category = this.categoryRepository.retrieveCategory(id);
		// @TODO error code update
		// if(category == null) throw new HumanLibraryNotFoundException(ExceptionType.US10002, String.valueOf(id), "success");
		return category;
	}

	@Override
	public Category retrieveCategoryByCategoryName(String categoryName) {
		Category category = this.categoryRepository.retrieveCategoryByCategoryName(categoryName);
		// @TODO error code update
		// if(category == null) throw new HumanLibraryNotFoundException(ExceptionType.US10002, String.valueOf(categoryName), "success");
		return category;
	}

	@Override
	public Long createCategory(Category category) {
		return this.categoryRepository.createCategory(category);
	}

	@Override
	public void modifyCategory(Category category) {
		this.categoryRepository.modifyCategory(category);
	}

	@Override
	public void removeCategory(Long id) {
		this.categoryRepository.removeCategory(id);
	}

	@Override
	public int countCategory() {
		return this.categoryRepository.countCategory();
	}

	@Override
	public CategorySearch retrieveCategoryBySearch(CategorySearch search) {
		return this.categoryRepository.retrieveCategoryBySearch(search);
	}
	
}
