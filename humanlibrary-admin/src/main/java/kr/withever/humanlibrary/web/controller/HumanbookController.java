package kr.withever.humanlibrary.web.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.service.CategoryService;
import kr.withever.humanlibrary.service.HumanbookService;
import kr.withever.humanlibrary.service.UserService;

@RestController
@RequestMapping(value = "/humanbooks")
public class HumanbookController {
	// @TODO 휴먼북 심사 완료(휴먼북 수락) 했을 경우 푸시메시지 보내줘야함.
	//	Humanbook humanbook = this.humanbookService.retrieveHumanbook(hbId);
	//	FCMInfo fcmInfo = fcmInfoService.retrieveFCMInfoByUserId(humanbook.getUser().getUserId());
	//	FCMUtil.sendMessage(fcmInfo.getToken(), FCMNotification.completeHumanbook(), FCMData.setting());


	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private HumanbookService humanbookService;
	
//	@RequestMapping(value = "/auto", method = RequestMethod.GET)
//	public @ResponseBody List<User> retrieveUserListForAutoComplete(
//			UserSearch search
//	){
//		System.out.println("here");
//		UserSearch userList = this.userService.retrieveUserBySearch(search);
//		return userList.getResults();
//	}
	
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
			@ModelAttribute Humanbook humanbook
	){
		Humanbook newHumanbook = updateToHumanbookDAO(humanbook);
		this.humanbookService.createHumanbook(newHumanbook);

		ModelAndView mav = new ModelAndView("redirect:/humanbooks");
		return mav;
	}
	
	@RequestMapping(value = "/{humanbookId}", method = RequestMethod.DELETE)
	public void deleteHumanbook(
			@PathVariable Long humanbookId
	){
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
		
		List<String> serviceDayList = new ArrayList<>();
		serviceDayList.addAll(humanbook.getServiceDay());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/humanbook/edit");
		mav.addObject("selectedHumanbook", humanbook);
		mav.addObject("categoryList", categoryList);
		mav.addObject("serviceDayList", serviceDayList);
		
		return mav;
	}

	@RequestMapping(value = "/edit/{humanbookId}", method = RequestMethod.POST)
	public ModelAndView updateHumanbook(
			@ModelAttribute Humanbook humanbook,
			@PathVariable Long humanbookId
	){
		humanbook.setId(humanbookId);
		Humanbook updatedHumanbook = updateToHumanbookDAO(humanbook);

		this.humanbookService.modifyHumanbook(updatedHumanbook);
		
		ModelAndView mav = new ModelAndView("redirect:/humanbooks");
		return mav;
	}
	
	private Humanbook updateToHumanbookDAO(Humanbook humanbook){
		User user = this.userService.retrieveUser(humanbook.getUser().getUserId());
		humanbook.setUser(user);
		
		Category category = this.categoryService.retrieveCategory(humanbook.getParentCategory().getId());
		humanbook.setParentCategory(category);
		
		category = this.categoryService.retrieveCategory(humanbook.getSubCategory().getId());
		humanbook.setSubCategory(category);
				
		Set<String> serviceDayList = new HashSet<String>(humanbook.getServiceDay());
		humanbook.setServiceDay(serviceDayList);
		
		return humanbook;
	}
}
