package kr.withever.humanlibrary.repo;

import kr.withever.humanlibrary.domain.User;
import kr.withever.humanlibrary.repo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
@Repository
public class UserRepository {

    @Autowired UserMapper userMapper;

    public User retrieveUser (Long userId) {
        return this.userMapper.selectUser(userId);
    }
}
