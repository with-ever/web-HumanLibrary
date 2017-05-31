package kr.withever.humanlibrary.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by youngjinkim on 2017. 5. 31..
 */
public class FCMUtil {

    private static final String SERVER_KEY = "AAAA80w5VZw:APA91bGm7Vh5llVx3z54uny4mKPsRmqfG0tpq-AifKjKjp0X4b_IDDhbuXwioxzYoslZBwF-cyeYdBb6rc5PSQsj85f8aG-IKFTl6R5HTVuun8Pz_sB27NEwTh4Ro-ZZWCRiPveqTxEs";

    private static final String FCM_URL = "https://fcm.googleapis.com/fcm/send";

    // @TODO 필요 상황에 따라 계약서 및 다른 아이디 세팅.
    public static void sendMessage(String tokenId, String message) throws IOException {

        URL url = new URL(FCM_URL);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + SERVER_KEY);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        conn.setDoInput(true);

        Map<String, Object> notification = new HashMap<>();
        // @TODO change title message
        notification.put("title", "title");
        notification.put("body", message);

        Map<String, Object> json = new HashMap<>();
        json.put("to", tokenId);
        json.put("notification", notification);

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(json);

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(conn.getOutputStream());
        outputStreamWriter.write(jsonString);
        outputStreamWriter.flush();
        outputStreamWriter.close();

        // @TODO 성공시 어떻게 처리 할 것인가
        if (conn != null) {
            conn.getResponseCode();
        }

    }
}
