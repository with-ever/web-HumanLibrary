package kr.withever.humanlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import kr.withever.humanlibrary.service.CategoryService;


@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView retrieveCategoryList(
			CategorySearch search
	) {
		CategorySearch categorySearch = this.categoryService.retrieveCategoryBySearch(search);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/category/list");
		mav.addObject("searchModel", categorySearch);
		return mav;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView showCreateCategoryForm(
			CategorySearch search
	) {
		search.setLimit(this.categoryService.countCategory());
		CategorySearch categorySearch = this.categoryService.retrieveCategoryBySearch(search);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("searchModel", categorySearch);
		mav.setViewName("/category/new");
		return mav;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView createCategory(
			Category category
	){
		String categoryName = category.getCategoryName();
		String desc = category.getDesc();
		Long parentCategory = category.getParentCategoryId();
		if(parentCategory == 0) parentCategory = null;
		
		Category newCategory = new Category(null, categoryName, desc, parentCategory);
		this.categoryService.createCategory(newCategory);
		
		ModelAndView mav = new ModelAndView("redirect:/categories");
		return mav;
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.DELETE)
	public void deleteCategory(
			@PathVariable Long categoryId
	){
		//자식카테고리가 있는지 확인 로직 필요
		this.categoryService.removeCategory(categoryId);
	}
	
	@RequestMapping(value = "/edit/{categoryId}", method = RequestMethod.POST)
	public ModelAndView updateCategory(
			Category updatedCategory,
			@PathVariable Long categoryId
	){
		updatedCategory.setId(categoryId);
		this.categoryService.modifyCategory(updatedCategory);
		
		ModelAndView mav = new ModelAndView("redirect:/categories");
		return mav;
	}
	
	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public ModelAndView showDetailCategory(
			@PathVariable Long categoryId,
			CategorySearch search
	){
		ModelAndView mav = new ModelAndView();
		
		search.setLimit(this.categoryService.countCategory());
		Category category = this.categoryService.retrieveCategory(categoryId);
		CategorySearch categorySearch = this.categoryService.retrieveCategoryBySearch(search);
		
		mav.setViewName("/category/edit");
		mav.addObject("selectedCategory", category);
		mav.addObject("searchModel", categorySearch);
		
		return mav;
	}
	
}
