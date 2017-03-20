package kr.withever.humanlibrary.web.controller;

import kr.withever.humanlibrary.security.LoginUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by youngjinkim on 2017. 3. 20..
 */
@RestController
@RequestMapping(value = "/board")
public class BoardController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView retrieveBoardList(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "board list");
        mav.setViewName("/board/list");
        return mav;
    }

}
