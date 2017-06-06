package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.common.user.RoleType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;

import java.util.Set;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public interface UserService {
    Long createUser(User user);

    User retrieveUser(Long userId);

    void modifyUser(User user);

    void removeUser(Long userId);

    User retrieveUserByLoginId(String loginId);

    UserSearch retrieveUserBySearch(UserSearch search);

    void modifyUserPassword(Long userId, String newPassword);

    String retrievePasswordByUserId(Long userId);

    void addUserRoles(Long userId, Set<String> roles);

    void removeUserRole(Long userId, String role);

}
