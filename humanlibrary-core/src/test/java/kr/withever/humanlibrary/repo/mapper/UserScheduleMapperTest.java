package kr.withever.humanlibrary.repo.mapper;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import kr.withever.humanlibrary.config.WitheverDbUnitTestConfig;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.domain.user.UserSchedule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by youngjinkim on 2017. 3. 8..
 */
@DatabaseSetup(value = {"/dataset/UserSchedule.xml"}, type = DatabaseOperation.INSERT)
@DatabaseTearDown(value = {"/dataset/UserSchedule.xml"}, type = DatabaseOperation.DELETE_ALL)
public class UserScheduleMapperTest extends WitheverDbUnitTestConfig {

    @Autowired
    private UserScheduleMapper userScheduleMapper;

    @Test
    public void insertUserSchedule() throws Exception {
        UserSchedule userSchedule = new UserSchedule();
        userSchedule.setUser(new User(2L));
        userSchedule.setContract(new Contract(1L));
        userSchedule.setDate("20170309");
        userSchedule.setTime("12");
        this.userScheduleMapper.insertUserSchedule(userSchedule);

        UserSchedule insertedUserSchedule = this.userScheduleMapper.selectUserSchedule(4L);

        assertEquals(userSchedule.getId(), insertedUserSchedule.getId());
        assertEquals(userSchedule.getUser().getUserId(), insertedUserSchedule.getUser().getUserId());
        assertEquals(userSchedule.getContract().getId(), insertedUserSchedule.getContract().getId());
        assertEquals(userSchedule.getDate(), insertedUserSchedule.getDate());
        assertEquals(userSchedule.getTime(), insertedUserSchedule.getTime());

    }

    @Test
    public void selectUserSchedule() throws Exception {
        UserSchedule userSchedule = this.userScheduleMapper.selectUserSchedule(1L);
        assertEquals(1L, (long) userSchedule.getId());
        assertEquals(2L, (long) userSchedule.getUser().getUserId());
        assertEquals(2L, (long) userSchedule.getContract().getId());
        assertEquals("20170308", userSchedule.getDate());
        assertEquals("12", userSchedule.getTime());
    }

    @Test
    public void selectUserSchedules() throws Exception {
        List<UserSchedule> userSchedules = this.userScheduleMapper.selectUserSchedules(2L);
        assertEquals(3, userSchedules.size());
    }

    @Test
    public void updateUserSchedule() throws Exception {
        UserSchedule userSchedule = this.userScheduleMapper.selectUserSchedule(1L);
        userSchedule.setDate("20170309");
        userSchedule.setTime("22");

        this.userScheduleMapper.updateUserSchedule(userSchedule);

        UserSchedule updatedUserSchedule = this.userScheduleMapper.selectUserSchedule(1L);
        assertEquals(userSchedule.getDate(), updatedUserSchedule.getDate());
        assertEquals(userSchedule.getTime(), updatedUserSchedule.getTime());
    }

    @Test
    public void deleteUserSchedule() throws Exception {
        this.userScheduleMapper.deleteUserSchedule(1L);
        UserSchedule userSchedule = this.userScheduleMapper.selectUserSchedule(1L);
        assertNull(userSchedule);
    }

}