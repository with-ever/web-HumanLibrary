package kr.withever.humanlibrary.repo;

import kr.withever.humanlibrary.repo.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by youngjinkim on 2017. 3. 8..
 */

@Repository
public class UserRoleRepository {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public void createUserRoles (Long userId, Set<String> roles) {
        for (String role: roles) {
            this.userRoleMapper.insertUserRole(userId, role.toUpperCase());
        }
    }

    public Set<String> retrieveUserRoles (Long userId) {
        return this.userRoleMapper.selectUserRoleList(userId);
    }

    public void removeUserRole (Long userId, String role) {
        this.userRoleMapper.deleteUserRole(userId, role);
    }
}
