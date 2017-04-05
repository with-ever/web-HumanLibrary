package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.util.HumanLibraryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import kr.withever.humanlibrary.service.CategoryService;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.POST)
	public HumanLibraryResponse createCategory(
			@RequestBody Category category
	){
		return new HumanLibraryResponse(this.categoryService.createCategory(category));
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public Category retrieveCategory(
			@PathVariable(value = "categoryId") Long categoryId
	){
		return this.categoryService.retrieveCategory(categoryId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public CategorySearch retrieveCategoryList(
			CategorySearch search
	){
		return this.categoryService.retrieveCategoryBySearch(search);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void modifyCategory(
			@RequestBody Category category
	){
		this.categoryService.modifyCategory(category);
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.DELETE)
	public void removeCategory(
			@PathVariable(value = "categoryId") Long categoryId
	){
		this.categoryService.removeCategory(categoryId);
	}
}
