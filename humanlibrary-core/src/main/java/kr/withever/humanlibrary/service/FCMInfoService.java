package kr.withever.humanlibrary.service;

import kr.withever.humanlibrary.domain.common.client.FCMInfo;

/**
 * Created by youngjinkim on 2017. 6. 13..
 */
public interface FCMInfoService {

    void createFCMInfo(FCMInfo fcmInfo);

    FCMInfo retrieveFCMInfoByUserId(Long userId);

    FCMInfo retrieveFCMInfoByDeviceId(String deviceId);

    void modifyFCMInfo(FCMInfo fcmInfo);

    void removeFCMInfoByUserId(Long userId);

    void removeFCMInfoByDeviceId(String deviceId);

}
