package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.Role;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 2. 13..
 */
public interface UserRoleMapper {

    List<Role> selectUserRoleList(Long userId);
}
