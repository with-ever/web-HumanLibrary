package kr.withever.humanlibrary.web.controller;

import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by youngjinkim on 2017. 4. 28..
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView showCreateUserForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/new");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView retrieveUserList(
            UserSearch search
    ) {
    	
        UserSearch userSearch = this.userService.retrieveUserBySearch(search);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/list");
        mav.addObject("searchModel", userSearch);
        return mav;
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public ModelAndView retreiveUser(
            @PathVariable(value = "userId") Long userId
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/detail");
        mav.addObject("user", this.userService.retrieveUser(userId));
        return mav;
    }

    @RequestMapping(value = "/{userId}/edit", method = RequestMethod.GET)
    public ModelAndView showModifyUserForm(
            @PathVariable(value = "userId") Long userId
    ) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/edit");
        mav.addObject("user", this.userService.retrieveUser(userId));
        return mav;
    }
}
