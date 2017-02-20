package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/**
 * Created by youngjinkim on 2017. 2. 10..
 */

@DatabaseSetup(value = {"/dataset/User.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/User.xml"}, type = DatabaseOperation.DELETE_ALL)
public class UserMapperTest extends WitheverDbUnitTestConfig {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectUser() throws Exception {
        User user = this.userMapper.selectUser(1L);
        assertEquals("jin", user.getLoginId());
    }

}