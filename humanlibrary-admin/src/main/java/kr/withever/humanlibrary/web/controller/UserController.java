package kr.withever.humanlibrary.web.controller;

import kr.withever.humanlibrary.domain.common.user.RoleType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.service.UserService;
import kr.withever.humanlibrary.util.AWSS3Util;
import kr.withever.humanlibrary.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by youngjinkim on 2017. 4. 28..
 */

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private static final String IMAGE_TYPE = "user";

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView showCreateUserForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/user/new");
        mav.addObject("roles", RoleType.values());
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView createUser(
            User user,
            @RequestParam(value = "image") MultipartFile multipartFile
    ) throws IOException {

        user.setPassword(encoder.encode(user.getPassword()));
        Long userId = this.userService.createUser(user);
        setImageUrlAndUpdate(userId, multipartFile);
        return new ModelAndView("redirect:/user/" + userId);
    }

    private void setImageUrlAndUpdate(Long userId, MultipartFile multipartFile) throws IOException {
        AWSS3Util s3Util = new AWSS3Util();
        String bucketName = s3Util.createBuckectName(IMAGE_TYPE);
        String fileName = s3Util.createFileName(userId.toString(), multipartFile.getOriginalFilename());
        s3Util.fileUpload(bucketName, fileName, FileUtil.convertMultipartFileToFile(multipartFile));

        String url = s3Util.getFileURL(bucketName, fileName);
        userService.modifyUserImageUrl(userId, url.split("\\?")[0]);

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
