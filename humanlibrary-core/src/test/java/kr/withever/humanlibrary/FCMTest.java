package kr.withever.humanlibrary;

import kr.withever.humanlibrary.util.FCMUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by youngjinkim on 2017. 5. 31..
 */
public class FCMTest {

    private static final String TEST_TOKEN_ID = "e3LPwtoeVvw:APA91bE6coOCqhFKp4bJsGWU7Ue5hF8lMkkS1PyGmbttmD8b9bGalPG4d0-3UElwVtLiX1UX0bRWTCQFVmmzoutBy02UCci7oXhXFnJG4JovDflAv_B5As4F7XzuPVTp_thmwnAGjbbp";

    @Test
    public void sendMessage() throws IOException {
        FCMUtil.sendMessage(TEST_TOKEN_ID, "지완아 일해야지?");
    }
}
