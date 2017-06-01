package kr.withever.humanlibrary.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by youngjinkim on 2017. 5. 31..
 */

@RestController
@RequestMapping(value = "/webview")
public class WebViewController {

    @RequestMapping(value = "/introduce", method = RequestMethod.GET)
    public ModelAndView showIntroducePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/webview/introduce");
        return mav;
    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public ModelAndView showHistoryPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/webview/history");
        return mav;
    }

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public ModelAndView showGreetingPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/webview/greeting");
        return mav;
    }

    @RequestMapping(value = "/management", method = RequestMethod.GET)
    public ModelAndView showManagementPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/webview/management");
        return mav;
    }

    @RequestMapping(value = "/business", method = RequestMethod.GET)
    public ModelAndView showBusinessPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/webview/business");
        return mav;
    }

}
