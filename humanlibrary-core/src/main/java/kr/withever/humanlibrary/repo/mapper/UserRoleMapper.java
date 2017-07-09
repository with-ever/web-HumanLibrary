package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.user.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by youngjinkim on 2017. 2. 13..
 */
@Mapper
public interface UserRoleMapper {

    int insertUserRole(@Param("userId") Long userId, @Param("roleId") String roleId);

    Set<String> selectUserRoleList(Long userId);

    int deleteUserRole(@Param("userId") Long userId, @Param("roleId") String roleId);

    List<Role> selectUserRoleListByUserIds(@Param("userIds") List<Long> userIds);
}
