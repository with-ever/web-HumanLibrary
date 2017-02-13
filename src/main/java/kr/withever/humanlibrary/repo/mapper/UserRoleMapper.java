package kr.withever.humanlibrary.repo.mapper;

import java.util.Set;

/**
 * Created by youngjinkim on 2017. 2. 13..
 */
public interface UserRoleMapper {

    Set<String> selectUserRoleList(Long userId);
}
