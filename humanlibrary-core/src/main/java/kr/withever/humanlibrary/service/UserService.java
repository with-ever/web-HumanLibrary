package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;

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
}
