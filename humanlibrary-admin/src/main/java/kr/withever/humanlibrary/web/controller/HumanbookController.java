package kr.withever.humanlibrary.web.controller;

import java.util.List;

import kr.withever.humanlibrary.domain.common.client.FCMData;
import kr.withever.humanlibrary.domain.common.client.FCMInfo;
import kr.withever.humanlibrary.domain.common.client.FCMNotification;
import kr.withever.humanlibrary.util.FCMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.service.CategoryService;
import kr.withever.humanlibrary.service.HumanbookService;

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
	public ModelAndView showCreateHumanbookForm() {
		List<Category> categoryList = this.categoryService.retrieveCategoriesWithSubCategory();
		ModelAndView mav = new ModelAndView();
		mav.addObject("categoryList", categoryList);
		mav.setViewName("/humanbook/new");
		return mav;
	}
}
