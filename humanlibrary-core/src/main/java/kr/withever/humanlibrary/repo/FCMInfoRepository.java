package kr.withever.humanlibrary.repo;

import kr.withever.humanlibrary.domain.common.client.FCMInfo;
import kr.withever.humanlibrary.repo.mapper.FCMInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by youngjinkim on 2017. 6. 13..
 */
@Repository
public class FCMInfoRepository {

    @Autowired
    private FCMInfoMapper fcmInfoMapper;

    public void createFCMInfo(FCMInfo fcmInfo) {
        this.fcmInfoMapper.insertFCMInfo(fcmInfo);
    }

    public FCMInfo retrieveFCMInfoByUserId(Long userId) {
        return this.fcmInfoMapper.selectFCMInfoByUserId(userId);
    }

    public FCMInfo retrieveFCMInfoByDeviceId(String deviceId) {
        return this.fcmInfoMapper.selectFCMInfoByDeviceId(deviceId);
    }

    public  void modifyFCMInfo(FCMInfo fcmInfo) {
        this.fcmInfoMapper.updateFCMInfo(fcmInfo);
    }

    public void removeFCMInfoByUserId(Long userId) {
        this.fcmInfoMapper.deleteFCMInfoByUserId(userId);
    }

    public void removeFCMInfoByDeviceId(String deviceId) {
        this.fcmInfoMapper.deleteFCMInfoByDeviceId(deviceId);
    }

}
