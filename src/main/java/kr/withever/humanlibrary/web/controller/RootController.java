package kr.withever.humanlibrary.web.controller;

import kr.withever.humanlibrary.security.LoginUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RootController {
	
	@RequestMapping(value = "/")
	public ModelAndView index(){
		System.out.println(LoginUser.getLoginUser().getUsername());
		System.out.println(LoginUser.getLoginUser().getPassword());
		System.out.println(LoginUser.getLoginUser().getRoles());
		return new ModelAndView("/index");
	}
}
