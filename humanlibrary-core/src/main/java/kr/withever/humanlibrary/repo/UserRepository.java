package kr.withever.humanlibrary.repo;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
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

    public Long createUser(User user) {
        this.userMapper.insertUser(user);
        return user.getUserId();
    }


    public User retrieveUser(Long userId) {
        User user = this.userMapper.selectUser(userId);
        if (user != null) {
            Set<String> roleList = this.userRoleMapper.selectUserRoleList(userId);
            user.setRoles(roleList);
        }
        return user;
    }

    public void modifyUser(User user) {
        try {
            this.userMapper.updateUser(user);
        } catch (Exception e) {
            // @TODO exception 코드 정리 필요.
            throw new HumanLibraryRuntimeException(e, ExceptionType.US_500_001
            );
        }

    }

    public void removeUser(Long userId) {
        try {
            this.userMapper.deleteUser(userId);
        } catch (Exception e) {
            // @TODO exception 코드 정리 필요.
            throw new HumanLibraryRuntimeException(e, ExceptionType.US_500_002);
        }

    }

    public User retrieveUserByLoginId(String loginId) {
        User user = this.userMapper.selectUserByLoginId(loginId);
        if (user != null) {
            Set<String> roleList = this.userRoleMapper.selectUserRoleList(user.getUserId());
            user.setRoles(roleList);
        }
        return user;
    }

    public UserSearch retrieveUserBySearch(UserSearch search) {
        List<User> users = this.userMapper.selectUsersBySearch(search);
        search.setResults(users);
        if (users.size() != 0) {
            int totalCount = this.userMapper.selectUsersTotalCountBySearch(search);
            search.setTotalCount(totalCount);
        }
        return search;
    }

}
