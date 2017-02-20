package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.User;
import kr.withever.humanlibrary.repo.UserRepository;
import kr.withever.humanlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User retrieveUser(Long userId) {
        return this.userRepository.retrieveUser(userId);
    }
}
