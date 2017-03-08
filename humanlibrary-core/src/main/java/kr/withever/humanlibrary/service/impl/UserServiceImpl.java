package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.common.user.RoleType;
import kr.withever.humanlibrary.domain.user.Role;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.repo.UserRepository;
import kr.withever.humanlibrary.repo.UserRoleRepository;
import kr.withever.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Long createUser(User user) {
        user.setTimeInfo();
        this.userRepository.createUser(user);
        this.userRoleRepository.createUserRoles(user.getUserId(), user.getRoles());
        return user.getUserId();
    }

    @Override
    public User retrieveUser(Long userId) {
        User user = this.userRepository.retrieveUser(userId);
        // @TODO exception 코드 정리 필요.
        if (user == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(userId), "success");
        return user;
    }

    @Override
    public void modifyUser(User user) {
        this.userRepository.modifyUser(user);
    }

    @Override
    public void removeUser(Long userId) {
        this.userRepository.removeUser(userId);
    }

    @Override
    public User retrieveUserByLoginId(String loginId) {
        User user = this.userRepository.retrieveUserByLoginId(loginId);
        // @TODO exception 코드 정리 필요.
        if (user == null) throw new HumanLibraryException(ExceptionType.US10002, String.valueOf(loginId), "success");
        return user;
    }

    @Override
    public UserSearch retrieveUserBySearch(UserSearch search) {
        return this.userRepository.retrieveUserBySearch(search);
    }

}
