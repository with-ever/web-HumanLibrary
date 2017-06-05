package kr.withever.humanlibrary;

import kr.withever.humanlibrary.domain.common.client.FCMData;
import kr.withever.humanlibrary.domain.common.client.FCMNotification;
import kr.withever.humanlibrary.util.FCMUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by youngjinkim on 2017. 5. 31..
 */
public class FCMTest {

    private static final String TEST_TOKEN_ID = "fNo8l-lwtMI:APA91bF4bxMrk7moceQWDu9KSO6N4HVGYn9L6MnQjjV3hJxisnWBOTuQ1JVQADf0RZ3XxOHwQhWp9ykirYUWbEQsBlWkQvyvWlERq7jpdgZ1CZoCqZePs9DdHp6cTF59wRTe9wdLcUYY";

    @Test
    public void sendMessage() throws IOException {
        FCMUtil.sendMessage(TEST_TOKEN_ID, new FCMNotification("title test","message test"), FCMData.contract("5"));
    }
}
