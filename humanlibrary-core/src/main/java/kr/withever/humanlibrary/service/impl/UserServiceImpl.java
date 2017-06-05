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
        user = encryptUser(user);
        this.userRepository.createUser(user);
        this.userRoleRepository.createUserRoles(user.getUserId(), user.getRoles());
        return user.getUserId();
    }

    @Override
    public User retrieveUser(Long userId) {
        User user = this.userRepository.retrieveUser(userId);
        if (user != null) user = decryptUser(user);
//        if (user == null) throw new HumanLibraryNotFoundException(ExceptionType.US_404_001, String.valueOf(userId));
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
//        if (user == null) throw new HumanLibraryNotFoundException(ExceptionType.US_404_002, String.valueOf(loginId));
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

    // @TODO 예외처리 어떻게 할것인지 고민.
    private User encryptUser(User user) {
        AESEncryptionUtil aesEncryptionUtil = new AESEncryptionUtil();

        try {
            user.setEmail(aesEncryptionUtil.encrypt(user.getEmail()));
            user.setPhoneNo(aesEncryptionUtil.encrypt(user.getPhoneNo()));
            user.setmPhoneNo(aesEncryptionUtil.encrypt(user.getmPhoneNo()));
            user.setAddress(aesEncryptionUtil.encrypt(user.getAddress()));
            user.setDetailAddress(aesEncryptionUtil.encrypt(user.getDetailAddress()));
        } catch (Exception e) {
            throw new RuntimeException("개인정보 암호화시 실패", e);
        }
        return user;
    }

    // @TODO 예외처리 어떻게 할것인지 고민.
    private User decryptUser(User user) {
        AESEncryptionUtil aesEncryptionUtil = new AESEncryptionUtil();

        try {
            user.setEmail(aesEncryptionUtil.decrypt(user.getEmail()));
            user.setPhoneNo(aesEncryptionUtil.decrypt(user.getPhoneNo()));
            user.setmPhoneNo(aesEncryptionUtil.decrypt(user.getmPhoneNo()));
            user.setAddress(aesEncryptionUtil.decrypt(user.getAddress()));
            user.setDetailAddress(aesEncryptionUtil.decrypt(user.getDetailAddress()));
        } catch (Exception e) {
            throw new RuntimeException("개인정보 암호화시 실패", e);
        }

        return user;
    }

    @Override
    public void addUserRoles(Long userId, Set<String> roles) {
        this.userRoleRepository.createUserRoles(userId, roles);
    }

    @Override
    public void removeUserRole(Long userId, String role) {
        this.userRoleRepository.removeUserRole(userId, role);
    }
}
