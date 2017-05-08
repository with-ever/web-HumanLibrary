package kr.withever.humanlibrary.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by youngjinkim on 2017. 4. 28..
 */
@RestController
@RequestMapping(value = "/front")
public class FrontController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView showUIForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/front/form");
        return mav;
    }

    @RequestMapping(value = "/button", method = RequestMethod.GET)
    public ModelAndView showUIButton() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/front/button");
        return mav;
    }

    @RequestMapping(value = "/icon", method = RequestMethod.GET)
    public ModelAndView showUIIcon() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/front/icon");
        return mav;
    }

}
