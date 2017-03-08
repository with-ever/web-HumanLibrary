package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.domain.user.UserSchedule;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 3. 8..
 */
public interface UserScheduleMapper {

    int insertUserSchedule(UserSchedule userSchedule);

    UserSchedule selectUserSchedule(Long scheduleId);

    List<UserSchedule> selectUserSchedules(Long userId);

    int updateUserSchedule(UserSchedule userSchedule);

    int deleteUserSchedule(Long scheduleId);

}
