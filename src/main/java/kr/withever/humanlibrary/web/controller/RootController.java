package kr.withever.humanlibrary.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RootController {
	
	@RequestMapping(value = "/")
	public ModelAndView index(){
		return new ModelAndView("/index");
	}
}
