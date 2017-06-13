package kr.withever.humanlibrary.service.impl;

import kr.withever.humanlibrary.domain.common.client.ClientPlatform;
import kr.withever.humanlibrary.domain.common.client.FCMInfo;
import kr.withever.humanlibrary.repo.FCMInfoRepository;
import kr.withever.humanlibrary.service.FCMInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by youngjinkim on 2017. 6. 13..
 */
@Service
@Transactional
public class FCMInfoServiceImpl implements FCMInfoService {

    @Autowired
    private FCMInfoRepository fcmInfoRepository;

    @Override
    public void createFCMInfo(FCMInfo fcmInfo) {
        if (fcmInfo.getPlatform() == null) fcmInfo.setPlatform(ClientPlatform.ANDROID.name());
        this.fcmInfoRepository.createFCMInfo(fcmInfo);
    }

    @Override
    public FCMInfo retrieveFCMInfoByUserId(Long userId) {
        return this.fcmInfoRepository.retrieveFCMInfoByUserId(userId);
    }

    @Override
    public FCMInfo retrieveFCMInfoByDeviceId(String deviceId) {
        return this.fcmInfoRepository.retrieveFCMInfoByDeviceId(deviceId);
    }

    @Override
    public void modifyFCMInfo(FCMInfo fcmInfo) {
        this.fcmInfoRepository.modifyFCMInfo(fcmInfo);
    }

    @Override
    public void removeFCMInfoByUserId(Long userId) {
        this.fcmInfoRepository.removeFCMInfoByUserId(userId);
    }

    @Override
    public void removeFCMInfoByDeviceId(String deviceId) {
        this.fcmInfoRepository.removeFCMInfoByDeviceId(deviceId);
    }
}
