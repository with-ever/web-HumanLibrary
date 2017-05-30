package kr.withever.humanlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import kr.withever.humanlibrary.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView retrieveCategoryList(
			CategorySearch search
	) {
		CategorySearch categorySearch = this.categoryService.retrieveCategoryBySearch(search);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/category/listNform");
		mav.addObject("searchModel", categorySearch);
		return mav;
	}
}
