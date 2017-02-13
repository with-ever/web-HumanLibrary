package kr.withever.humanlibrary.repo;

import kr.withever.humanlibrary.domain.Role;
import kr.withever.humanlibrary.domain.User;
import kr.withever.humanlibrary.repo.mapper.UserMapper;
import kr.withever.humanlibrary.repo.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
@Repository
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    public User retrieveUser(Long userId) {
        User user = this.userMapper.selectUser(userId);
        Set<String> roleList = this.userRoleMapper.selectUserRoleList(userId);
        user.setRoles(roleList);
        return user;

    }
}
