package kr.withever.humanlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.repo.CategoryRepository;
import kr.withever.humanlibrary.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	@Autowired 
	private CategoryRepository categoryRepository;

	@Override
	public Category selectCategory(Long id) {
		return this.categoryRepository.selectCategory(id);
	}

	@Override
	public Category selectCategoryByCategoryName(String categoryName) {
		return this.categoryRepository.selectCategoryByCategoryName(categoryName);
	}

	@Override
	public int insertCategory(Category category) {
		try {
			this.categoryRepository.insertCategory(category);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int updateCategory(Category category) {
		try {
			this.categoryRepository.updateCategory(category);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int deleteCategory(Long id) {
		try {
			this.categoryRepository.deleteCategory(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int countCategory() {
		return this.categoryRepository.countCategory();
	}
	
}
