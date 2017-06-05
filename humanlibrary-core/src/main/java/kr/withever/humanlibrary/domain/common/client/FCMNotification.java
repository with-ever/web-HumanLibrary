package kr.withever.humanlibrary.domain.common.client;

import java.io.Serializable;

/**
 * Created by youngjinkim on 2017. 6. 5..
 */
public class FCMNotification {

    private String title;

    private String body;

    public FCMNotification(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
