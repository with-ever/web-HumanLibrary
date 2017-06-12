package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.common.client.FCMData;
import kr.withever.humanlibrary.domain.common.client.FCMNotification;
import kr.withever.humanlibrary.util.FCMUtil;
import kr.withever.humanlibrary.util.HumanLibraryResponse;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by youngjinkim on 2017. 2. 22..
 */
@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    @Value("${client.id}")
    private String clientId;

    @Value("${client.secret}")
    private String clientSecret;

    @RequestMapping(method = RequestMethod.GET)
    public String retrieveBasicToken () {
        String basicToken = String.join(":", clientId, clientSecret);
        String encodedBasicToken = Base64.encodeBase64String(basicToken.getBytes());
        return encodedBasicToken;
    }

    @RequestMapping(value = "/fcm", method = RequestMethod.POST)
    public HumanLibraryResponse sendFCMMessage(
            @RequestParam("token") String token,
            @RequestParam("title") String title,
            @RequestParam("message") String message
    ) throws IOException {
        FCMUtil.sendMessage(token, new FCMNotification(title,message), FCMData.contract("5"));
        return HumanLibraryResponse.successMessage();
    }

}
