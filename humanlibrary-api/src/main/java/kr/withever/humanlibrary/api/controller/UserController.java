package kr.withever.humanlibrary.api.controller;

import io.swagger.annotations.ApiParam;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.service.UserService;
import kr.withever.humanlibrary.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

}