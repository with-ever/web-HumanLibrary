package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.repo.UserRepository;
import kr.withever.humanlibrary.repo.UserRoleRepository;
import kr.withever.humanlibrary.service.UserService;
import kr.withever.humanlibrary.util.AESEncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
        user = User.encryptUser(user);
        this.userRepository.createUser(user);
        this.userRoleRepository.createUserRoles(user.getUserId(), user.getRoles());
        return user.getUserId();
    }

    @Override
    public User retrieveUser(Long userId) {
        User user = this.userRepository.retrieveUser(userId);
        if (user != null) user = User.decryptUser(user);
//        if (user == null) throw new HumanLibraryNotFoundException(ExceptionType.US_404_001, String.valueOf(userId));
        return user;
    }

    @Override
    public void modifyUser(User user) {
        User previousUser = this.userRepository.retrieveUser(user.getUserId());
        previousUser = User.decryptUser(previousUser);
        previousUser.setUpdatedUser(user);
        previousUser = User.encryptUser(previousUser);
        this.userRepository.modifyUser(previousUser);
    }

    @Override
    public void removeUser(Long userId) {
        this.userRepository.removeUser(userId);
    }

    @Override
    public User retrieveUserByLoginId(String loginId) {
        User user = this.userRepository.retrieveUserByLoginId(loginId);
        if (user != null) user = User.decryptUser(user);
//        if (user == null) throw new HumanLibraryNotFoundException(ExceptionType.US_404_002, String.valueOf(loginId));
        return user;
    }

    @Override
    public User retrieveUserByLoginIdWithoutPassword(String loginId) {
        User user = this.userRepository.retrieveUserByLoginIdWithoutPassword(loginId);
        if (user != null) user = User.decryptUser(user);
//        if (user == null) throw new HumanLibraryNotFoundException(ExceptionType.US_404_002, String.valueOf(loginId));
        return user;
    }

    @Override
    public UserSearch retrieveUserBySearch(UserSearch search) {
        search = this.userRepository.retrieveUserBySearch(search);
        List<User> users = search.getResults();
        if (users.size() != 0) {
            for (int index = 0; index < users.size(); index++) {
                users.set(index, User.decryptUser(users.get(index)));
            }
        }
        search.setResults(users);
        return search;
    }

    @Override
    public void modifyUserPassword(Long userId, String newPassword) {
        this.userRepository.modifyUserPassword(userId, newPassword);
    }

    @Override
    public String retrievePasswordByUserId(Long userId) {
        return this.userRepository.retrievePasswordByUserId(userId);
    }



    @Override
    public void addUserRoles(Long userId, Set<String> roles) {
        this.userRoleRepository.createUserRoles(userId, roles);
    }

    @Override
    public void removeUserRole(Long userId, String role) {
        this.userRoleRepository.removeUserRole(userId, role);
    }

    @Override
    public void modifyUserImageUrl(Long userId, String imageUrl) {
        this.userRepository.modifyUserImageUrl(userId, imageUrl);
    }
}
