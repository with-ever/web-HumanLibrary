package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.user.User;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public interface UserService {

    User retrieveUser(Long userId);
}
