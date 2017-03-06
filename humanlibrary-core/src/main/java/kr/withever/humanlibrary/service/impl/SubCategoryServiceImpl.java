package kr.withever.humanlibrary.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.SubCategoryRepository;
import kr.withever.humanlibrary.service.SubCategoryService;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Override
	public SubCategory retrieveSubCategory(Long id) {
		SubCategory subCategory =  this.subCategoryRepository.retrieveSubCategory(id);
		if (subCategory == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(id), "success");
		return subCategory;
	}

	@Override
	public SubCategory retrieveSubCategoryByCategoryName(String categoryName) {
		SubCategory subCategory =  this.subCategoryRepository.retrieveSubCategoryByCategoryName(categoryName);
		if (subCategory == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(categoryName), "success");
		return subCategory;
	}

	@Override
	public int insertSubCategory(SubCategory subCategory) {
		return this.subCategoryRepository.insertSubCategory(subCategory);
	}

	@Override
	public int updateSubCategory(SubCategory subCategory) {
		return this.subCategoryRepository.updateSubCategory(subCategory);
	}

	@Override
	public int deleteSubCategory(Long id) {
		return this.subCategoryRepository.deleteSubCategory(id);
	}
}
