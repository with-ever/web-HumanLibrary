package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.common.client.FCMInfo;
import kr.withever.humanlibrary.domain.contract.Contract;
import kr.withever.humanlibrary.service.FCMInfoService;
import kr.withever.humanlibrary.util.HumanLibraryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by youngjinkim on 2017. 6. 13..
 */
@RestController
@RequestMapping(value = "/api/fcminfo")
public class FCMInfoController {

    @Autowired
    private FCMInfoService fcmInfoService;

    @RequestMapping(method = RequestMethod.POST)
    public HumanLibraryResponse createFCMInfo(
            @RequestBody FCMInfo fcmInfo
    ) {
        this.fcmInfoService.createFCMInfo(fcmInfo);
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/{deviceId}", method = RequestMethod.GET)
    public FCMInfo retrieveFCMInfo(
            @PathVariable(value = "deviceId") String deviceId
    ) {
        return this.fcmInfoService.retrieveFCMInfoByDeviceId(deviceId);
    }

    @RequestMapping(value = "/{deviceId}", method = RequestMethod.PUT)
    public HumanLibraryResponse modifyFCMInfo(
            @PathVariable(value = "deviceId") String deviceId,
            @RequestBody FCMInfo fcmInfo
    ) {
        if (fcmInfo.getDeviceId() == null) fcmInfo.setDeviceId(deviceId);
        this.fcmInfoService.modifyFCMInfo(fcmInfo);
        return HumanLibraryResponse.successMessage();
    }

    @RequestMapping(value = "/{deviceId}", method = RequestMethod.DELETE)
    public HumanLibraryResponse removeFCMInfo(

            @PathVariable(value = "deviceId") String deviceId
    ) {
        this.fcmInfoService.removeFCMInfoByDeviceId(deviceId);
        return HumanLibraryResponse.successMessage();
    }

}
