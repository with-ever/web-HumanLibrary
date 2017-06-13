package kr.withever.humanlibrary.repo.mapper;

import kr.withever.humanlibrary.domain.board.Board;
import kr.withever.humanlibrary.domain.board.BoardSearch;
import kr.withever.humanlibrary.domain.common.client.FCMInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 6. 12..
 */
@Mapper
public interface FCMInfoMapper {

    int insertFCMInfo(FCMInfo fcmInfo);

    FCMInfo selectFCMInfoByUserId(Long userId);

    FCMInfo selectFCMInfoByDeviceId(String deviceId);

    int updateFCMInfo(FCMInfo fcmInfo);

    int deleteFCMInfoByUserId(Long userId);

    int deleteFCMInfoByDeviceId(String deviceId);

}
