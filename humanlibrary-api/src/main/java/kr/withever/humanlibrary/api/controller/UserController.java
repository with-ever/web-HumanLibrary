package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youngjinkim on 2017. 2. 6..
 */

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public Long createUser(
            @RequestBody User user
    ) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return this.userService.createUser(user);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User retrieveUser(
            @PathVariable(value = "userId") Long userId
    ) {
        return this.userService.retrieveUser(userId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public UserSearch retrieveUserList(
            UserSearch search
    ) {
        return this.userService.retrieveUserBySearch(search);
    }

    // need test. 20170310 by youngjin.
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public void modifyUser(
            @PathVariable(value = "userId") Long userId,
            @RequestBody User user
    ) {
        this.userService.modifyUser(user);
    }

    @RequestMapping(value="/verification/{loginId}", method = RequestMethod.GET)
    public Map<String, Boolean> verifyLoginId(
            @PathVariable(value="loginId") String loginId
    ) {
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        User user = this.userService.retrieveUserByLoginId(loginId);
        if (user != null) result.put("isExsited", true);
        return result;
    }

    @RequestMapping(value = "/password/{userId}", method = RequestMethod.PUT)
    public Map<String, String> changePassword(
            @PathVariable Long userId,
            @RequestBody Map<String, Object> requestParam
    ) {
        Map<String, String> result = new HashMap<String, String>();
        String password = (String) requestParam.get("password");
        String newPassword = (String) requestParam.get("newPassword");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.userService.modifyUserPassword(userId, encoder.encode(password), encoder.encode(newPassword));
        result.put("result", "success");
        return result;
    }

}