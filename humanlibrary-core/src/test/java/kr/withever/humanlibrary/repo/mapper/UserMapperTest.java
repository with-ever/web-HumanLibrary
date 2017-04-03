package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSearch;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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

        User insertedUser = this.userMapper.selectUser(3L);
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

    @Test
    public void selectUsersBySearch() throws Exception {
        UserSearch search = new UserSearch();
        search.setName("youngjin");
        search.setEmail("youngjin");
        List<User> users = this.userMapper.selectUsersBySearch(search);

        assertEquals(1, users.size());
    }

    @Test
    public void selectUsersTotalCountBySearch() throws Exception {
        UserSearch search = new UserSearch();
        search.setName("youngjin");
        search.setEmail("youngjin");
        int count = this.userMapper.selectUsersTotalCountBySearch(search);

        assertEquals(1, count);
    }

    @Test
    public void selectUserByIdWithPassword() throws Exception {
        boolean isExsited = this.userMapper.selectUserByIdWithPassword(2L, "1234");
        assertTrue(isExsited);
    }

    @Test
    public void updateUserPassword() throws Exception {
        this.userMapper.updateUserPassword(2L, "0000");
        boolean isExsited = this.userMapper.selectUserByIdWithPassword(2L, "0000");
        assertTrue(isExsited);
    }

    @Test
    public void selectPasswordByUserId() throws Exception {
        String password = this.userMapper.selectPasswordByUserId(2L);
        assertEquals(password, "1234");
    }

}