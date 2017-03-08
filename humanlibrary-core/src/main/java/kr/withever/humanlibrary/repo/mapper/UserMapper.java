package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public interface UserMapper {

    int insertUser(User user);

    User selectUser(Long userId);

    int updateUser(User user);

    int deleteUser(Long userId);

    User selectUserByLoginId(String loginId);

    List<User> selectUsersBySearch(UserSearch search);

    int selectUsersTotalCountBySearch(UserSearch search);
}
