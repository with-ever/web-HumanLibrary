package kr.withever.humanlibrary.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/custom")
public class CustomController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String custom() {
		return "test";
	}

}
