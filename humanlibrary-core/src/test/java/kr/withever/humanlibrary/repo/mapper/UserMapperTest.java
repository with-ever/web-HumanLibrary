package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.user.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by youngjinkim on 2017. 2. 10..
 */

@DatabaseSetup(value = {"/dataset/User.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/User.xml"}, type = DatabaseOperation.DELETE_ALL)
public class UserMapperTest extends WitheverDbUnitTestConfig {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser() throws Exception {
        User user = new User("yjkim", "김영진", "jin@gmail.com", "123456");
        this.userMapper.insertUser(user);

        User insertedUser = this.userMapper.selectUser(2L);
        assertEquals(user.getLoginId(), insertedUser.getLoginId());
        assertEquals(user.getName(), insertedUser.getName());
        assertEquals(user.getEmail(), insertedUser.getEmail());
        assertEquals(user.getPassword(), insertedUser.getPassword());
    }

    @Test
    public void selectUser() throws Exception {
        User user = this.userMapper.selectUser(1L);
        assertEquals("jin", user.getLoginId());
    }

    @Test
    public void updateUser() throws Exception {
        User user = this.userMapper.selectUser(1L);
        user.setName("jinjin");
        user.setAddress("1234");
        this.userMapper.updateUser(user);

        User updatedUser = this.userMapper.selectUser(1L);
        assertEquals(user.getName(), updatedUser.getName());
        assertEquals(user.getAddress(), updatedUser.getAddress());
    }

    @Test
    public void deleteUser() throws Exception {
        this.userMapper.deleteUser(1L);
        User user = this.userMapper.selectUser(1L);
        assertNull(user);
    }

    @Test
    public void selectUserByLoginId() throws Exception {
        User user = this.userMapper.selectUserByLoginId("jin");
        assertEquals("jin", user.getLoginId());
    }

}