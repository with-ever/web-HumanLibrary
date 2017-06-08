package kr.withever.humanlibrary;

import kr.withever.humanlibrary.domain.common.client.FCMData;
import kr.withever.humanlibrary.domain.common.client.FCMNotification;
import kr.withever.humanlibrary.util.FCMUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by youngjinkim on 2017. 5. 31..
 */
public class FCMTest {

    private static final String TEST_TOKEN_ID = "fNo8l-lwtMI:APA91bF4bxMrk7moceQWDu9KSO6N4HVGYn9L6MnQjjV3hJxisnWBOTuQ1JVQADf0RZ3XxOHwQhWp9ykirYUWbEQsBlWkQvyvWlERq7jpdgZ1CZoCqZePs9DdHp6cTF59wRTe9wdLcUYY";

    @Test
    @Ignore
    public void sendMessage() throws IOException {
        FCMUtil.sendMessage(TEST_TOKEN_ID, new FCMNotification("title test","message test"), FCMData.contract("5"));
    }

    @Test
    public void createMessageFormat() throws IOException {
        FCMNotification fcmNotification = FCMNotification.requestHumanbook("김영진");
        assertEquals("김영진 구독자가 구독신청을 하였습니다. 가능한 일정을 선택해주세요.", fcmNotification.getBody());
    }
}
