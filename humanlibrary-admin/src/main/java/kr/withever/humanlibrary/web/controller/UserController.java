package kr.withever.humanlibrary.web.controller;

import kr.withever.humanlibrary.domain.common.user.RoleType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

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
        mav.addObject("roles", RoleType.values());
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

    @RequestMapping(value="/verification/{loginId}", method = RequestMethod.GET)
    public Map verifyLoginId(
            @PathVariable(value = "loginId") String loginId
    ) {
        Map<String, Object> result = new HashMap<String, Object>();
        User user = this.userService.retrieveUserByLoginIdWithoutPassword(loginId);
        if (user != null) {
            result.put("isExisted", true);
        } else {
            result.put("isExisted", false);
        }
        return result;
    }
}
