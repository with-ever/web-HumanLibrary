package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
import kr.withever.humanlibrary.service.UserService;
import kr.withever.humanlibrary.util.HumanLibraryResponse;
import kr.withever.humanlibrary.util.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(method = RequestMethod.POST)
    public HumanLibraryResponse createUser(
            @RequestBody User user
    ) {
        user.setPassword(encoder.encode(user.getPassword()));
        Long userId = this.userService.createUser(user);
        return new HumanLibraryResponse(userId);
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

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
    public HumanLibraryResponse modifyUser(
            @PathVariable(value = "userId") Long userId,
            @RequestBody User user
    ) {
        user.setUserId(userId);
        this.userService.modifyUser(user);
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value="/verification/{loginId}", method = RequestMethod.GET)
    public HumanLibraryResponse verifyLoginId(
            @PathVariable(value = "loginId") String loginId
    ) {
        User user = this.userService.retrieveUserByLoginId(loginId);
        return user != null ? HumanLibraryResponse.isExisted() : HumanLibraryResponse.isNotExisted();
    }

    @RequestMapping(value = "/password/{userId}", method = RequestMethod.PUT)
    public HumanLibraryResponse changePassword(
            @PathVariable Long userId,
            @RequestBody Map<String, Object> requestParam
    ) {
        String password = (String) requestParam.get("password");
        String newPassword = (String) requestParam.get("newPassword");

        boolean isMatched = encoder.matches(password, this.userService.retrievePasswordByUserId(userId));
        if (!isMatched) return HumanLibraryResponse.failMessage();
        this.userService.modifyUserPassword(userId, encoder.encode(newPassword));
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/info/{loginId}", method = RequestMethod.GET)
    public User retrieveUserByLoginId(
            @PathVariable(value = "loginId") String loginId
    ) {
        return this.userService.retrieveUserByLoginId(loginId);
    }

}