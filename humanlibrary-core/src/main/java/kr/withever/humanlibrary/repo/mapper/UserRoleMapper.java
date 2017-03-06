package kr.withever.humanlibrary.repo.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * Created by youngjinkim on 2017. 2. 13..
 */
public interface UserRoleMapper {

    int insertUserRole(@Param("userId") Long userId, @Param("roleId") String roleId);

    Set<String> selectUserRoleList(Long userId);

    int deleteUserRole(@Param("userId") Long userId, @Param("roleId") String roleId);
}
