package kr.withever.humanlibrary.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.withever.humanlibrary.domain.humanbook.SubCategory;
import kr.withever.humanlibrary.domain.humanbook.SubCategorySearch;
import kr.withever.humanlibrary.service.SubCategoryService;

@RestController
@RequestMapping(value = "/api/subcategories")
public class SubCategoryController {

	@Autowired
	private SubCategoryService SubCategoryService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Long createSubCategory(
			@RequestBody SubCategory subCategory
	){
		return this.SubCategoryService.createSubCategory(subCategory);
	}
	
	@RequestMapping(value = "/{subCategoryId}", method = RequestMethod.GET)
	public SubCategory retrieveCategory(
			@PathVariable(value = "subCategoryId") Long subCategoryId
	){
		return this.SubCategoryService.retrieveSubCategory(subCategoryId);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void modifySubCategory(
			@RequestBody SubCategory subCategory
	){
		this.SubCategoryService.modifySubCategory(subCategory);
	}
	
	@RequestMapping(value = "/{subCategoryId}", method = RequestMethod.DELETE)
	public void removeSubCategory(
			@PathVariable(value = "subCategoryId") Long subCategoryId
	){
		this.SubCategoryService.removeSubCategory(subCategoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public SubCategorySearch retrieveSubCategoryList(
			SubCategorySearch search
	){
		return this.SubCategoryService.retrieveSubCategoriesBySearch(search);
	}
}
