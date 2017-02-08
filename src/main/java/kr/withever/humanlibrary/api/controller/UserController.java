package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.User;
import kr.withever.humanlibrary.repo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngjinkim on 2017. 2. 6..
 */

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(method = RequestMethod.GET)
    public List<User> retrieveUserList() {
        List<User> userList = new ArrayList<User>();
        return userList;
    }


    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public User retrieveUser(
            @PathVariable(value = "userId") String userId
    ) {
//        User user = new User("jinkim", "jin", "jin@gmail.com", "1234");
        User user;
        user = this.userMapper.selectUser(Long.parseLong(userId));
        return user;
    }

}