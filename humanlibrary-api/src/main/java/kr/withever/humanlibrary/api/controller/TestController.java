package kr.withever.humanlibrary.api.controller;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngjinkim on 2017. 2. 22..
 */
@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    private final static String clientId = "clientapp";

    private final static String clientSecret = "123456";

    @RequestMapping(method = RequestMethod.GET)
    public String retrieveBasicToken () {
        String basicToken = String.join(":", clientId, clientSecret);
        String encodedBasicToken = Base64.encodeBase64String(basicToken.getBytes());
        return encodedBasicToken;
    }

}
