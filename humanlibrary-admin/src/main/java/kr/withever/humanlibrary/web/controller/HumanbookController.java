package kr.withever.humanlibrary.web.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.CategorySearch;
import kr.withever.humanlibrary.domain.humanbook.Humanbook;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.service.CategoryService;
import kr.withever.humanlibrary.service.HumanbookService;
import kr.withever.humanlibrary.service.UserService;

@RestController
@RequestMapping(value = "/humanbooks")
public class HumanbookController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private HumanbookService humanbookService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView retrieveHumanbookList(
			HumanbookSearch search
	){
		HumanbookSearch humanbookSearch = this.humanbookService.retrieveHumanbooksBySearch(search);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/humanbook/list");
		mav.addObject("searchModel", humanbookSearch);
		return mav;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView showCreateHumanbookForm(
			
	) {
		List<Category> categoryList = this.categoryService.retrieveCategoriesWithSubCategory();
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryList", categoryList);
		mav.setViewName("/humanbook/new");
		return mav;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ModelAndView createHumanbook(
			HttpServletRequest req
	){
		Humanbook humanbook = new Humanbook();
		
		Long userId = Long.parseLong(req.getParameter("userId"));
		User user = this.userService.retrieveUser(userId);
		humanbook.setUser(user);
		
		Long parentCategoryId = Long.parseLong(req.getParameter("parentCategory"));
		Category parentCategory = this.categoryService.retrieveCategory(parentCategoryId);
		humanbook.setParentCategory(parentCategory);
		
		Long subCategoryId = Long.parseLong(req.getParameter("subCategory"));
		Category subCategory = this.categoryService.retrieveCategory(subCategoryId);
		humanbook.setSubCategory(subCategory);
		
		humanbook.setServiceTime(req.getParameter("serviceTime"));
		humanbook.setImageUrl(req.getParameter("imageURL"));
		humanbook.setTitle(req.getParameter("title"));
		humanbook.setMainCareer(req.getParameter("mainCareer"));
		humanbook.setDescription(req.getParameter("description"));
		
		this.humanbookService.createHumanbook(humanbook);

		ModelAndView mav = new ModelAndView("redirect:/humanbooks");
		return mav;
	}
	
	@RequestMapping(value = "/{humanbookId}", method = RequestMethod.DELETE)
	public void deleteHumanbook(
			@PathVariable Long humanbookId
	){
		System.out.println(humanbookId);
		this.humanbookService.removeHumanbook(humanbookId);
	}
	
	@RequestMapping(value = "/{humanbookId}/reject", method = RequestMethod.PUT)
	public void rejectHumanbook(
			@PathVariable Long humanbookId
	){
		this.humanbookService.rejectHumanbookRegister(humanbookId);
	}
	
	@RequestMapping(value = "/{humanbookId}/accept", method = RequestMethod.PUT)
	public void acceptHumanbook(
			@PathVariable Long humanbookId
	){
		this.humanbookService.acceptHumanbookRegister(humanbookId);
	}
	
	@RequestMapping(value = "/subCategories", method = RequestMethod.POST)
	public @ResponseBody List<Category> retrieveSubCategories(
			CategorySearch search
	){
		search.setParentCategoryId(search.getParentCategoryId());
		int limit = this.categoryService.countSubCategory(search);
		search.setLimit(limit);
		
		CategorySearch subCategories = this.categoryService.retrieveCategoryBySearch(search);
		return subCategories.getResults();
	}
	
	@RequestMapping(value = "/{humanbookId}", method = RequestMethod.GET)
	public ModelAndView showDetailHumanbook(
			@PathVariable Long humanbookId
	){
		List<Category> categoryList = this.categoryService.retrieveCategoriesWithSubCategory();
		Humanbook humanbook = this.humanbookService.retrieveHumanbook(humanbookId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/humanbook/edit");
		mav.addObject("selectedHumanbook", humanbook);
		mav.addObject("categoryList", categoryList);
		
		return mav;
	}

	@RequestMapping(value = "/edit/{humanbookId}", method = RequestMethod.POST)
	public ModelAndView updateHumanbook(
			HttpServletRequest req,
			@PathVariable Long humanbookId
	){
		Humanbook updatedHumanbook = new Humanbook();
		updatedHumanbook.setId(humanbookId);
		
		Long userId = Long.parseLong(req.getParameter("userId"));
		User user = this.userService.retrieveUser(userId);
		updatedHumanbook.setUser(user);

		Long parentCategoryId = Long.parseLong(req.getParameter("parentCategory"));
		Category parentCategory = this.categoryService.retrieveCategory(parentCategoryId);
		updatedHumanbook.setParentCategory(parentCategory);
		
		Long subCategoryId = Long.parseLong(req.getParameter("subCategory"));
		Category subCategory = this.categoryService.retrieveCategory(subCategoryId);
		updatedHumanbook.setSubCategory(subCategory);

		updatedHumanbook.setServiceTime(req.getParameter("serviceTime"));
		updatedHumanbook.setImageUrl(req.getParameter("imageURL"));
		updatedHumanbook.setTitle(req.getParameter("title"));
		updatedHumanbook.setMainCareer(req.getParameter("mainCareer"));
		updatedHumanbook.setDescription(req.getParameter("description"));
		
		String[] serviceDays = req.getParameterValues("serviceDay");
		Set<String> serviceDayList = new HashSet<String>(Arrays.asList(serviceDays));
		updatedHumanbook.setServiceDay(serviceDayList);
		
		this.humanbookService.modifyHumanbook(updatedHumanbook);
		
		ModelAndView mav = new ModelAndView("redirect:/humanbooks");
		return mav;
	}
}
