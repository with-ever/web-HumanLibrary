package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.common.user.RoleType;
import kr.withever.humanlibrary.domain.user.Role;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.exception.HumanLibraryNotFoundException;
import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
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
        this.userRepository.createUser(user);
        this.userRoleRepository.createUserRoles(user.getUserId(), user.getRoles());
        return user.getUserId();
    }

    @Override
    public User retrieveUser(Long userId) {
        User user = this.userRepository.retrieveUser(userId);
        if (user == null) throw new HumanLibraryNotFoundException(ExceptionType.US_404_001, String.valueOf(userId));
        return user;
    }

    @Override
    public void modifyUser(User user) {
        User previousUser = this.userRepository.retrieveUser(user.getUserId());
        previousUser.setUpdatedUser(user);
        this.userRepository.modifyUser(previousUser);
    }

    @Override
    public void removeUser(Long userId) {
        this.userRepository.removeUser(userId);
    }

    @Override
    public User retrieveUserByLoginId(String loginId) {
        User user = this.userRepository.retrieveUserByLoginId(loginId);
        if (user == null) throw new HumanLibraryNotFoundException(ExceptionType.US_404_002, String.valueOf(loginId));
        return user;
    }

    @Override
    public UserSearch retrieveUserBySearch(UserSearch search) {
        return this.userRepository.retrieveUserBySearch(search);
    }

    @Override
    public void modifyUserPassword(Long userId, String newPassword) {
        this.userRepository.modifyUserPassword(userId, newPassword);
    }

    @Override
    public String retrievePasswordByUserId(Long userId) {
        return this.userRepository.retrievePasswordByUserId(userId);
    }
}
