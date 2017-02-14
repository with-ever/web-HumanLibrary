package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
public interface UserMapper {

    int insertUser(User user);

    User selectUser(Long userId);

    int updateUser(User user);

    int deleteUser(Long userId);

    User selectUserByLoginId(String loginId);
}
