package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.common.user.RoleType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by youngjinkim on 2017. 2. 13..
 */

@DatabaseSetup(value = {"/dataset/UserRole.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/UserRole.xml"}, type = DatabaseOperation.DELETE_ALL)
public class UserRoleMapperTest extends WitheverDbUnitTestConfig {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Test
    public void insertUserRole() throws Exception {
        this.userRoleMapper.insertUserRole(2L, RoleType.ADMIN.getName());
        Set<String> roleList = this.userRoleMapper.selectUserRoleList(2L);
        String role = roleList.iterator().next().toString();
        assertEquals(role, RoleType.ADMIN.getName());
        assertEquals(1, roleList.size());
    }

    @Test
    public void selectUserRoleList() throws Exception {
        Set<String> roleList = this.userRoleMapper.selectUserRoleList(1L);
        assertEquals(3, roleList.size());
        assertTrue(roleList.contains(RoleType.HUMAN_BOOK.name()));
    }

    @Test
    public void deleteUserRole() throws Exception {
        this.userRoleMapper.deleteUserRole(1L, RoleType.ADMIN.getName());
        Set<String> roleList = this.userRoleMapper.selectUserRoleList(1L);
        assertEquals(2, roleList.size());

    }

}