package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
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
    public void selectUserRoleList() throws Exception {
        Set<String> roleList = this.userRoleMapper.selectUserRoleList(1L);
        assertEquals(3, roleList.size());
    }

}