package kr.withever.humanlibrary.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.withever.humanlibrary.domain.humanbook.HumanbookSearch;
import kr.withever.humanlibrary.service.HumanbookService;

@RestController
@RequestMapping(value = "/humanbook")
public class HumanbookController {

	@Autowired
	private HumanbookService humanbookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView retrieveHumanbookList(
			HumanbookSearch search
	){
		HumanbookSearch humanbookSearch = this.humanbookService.retrieveHumanbooksBySearch(search);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/humanbook/listNform");
		mav.addObject("searchModel", humanbookSearch);
		return mav;
	}
}
