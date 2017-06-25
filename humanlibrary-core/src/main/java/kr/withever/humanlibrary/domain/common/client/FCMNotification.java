package kr.withever.humanlibrary.domain.common.client;

import java.io.Serializable;

/**
 * Created by youngjinkim on 2017. 6. 5..
 */
public class FCMNotification {

    private static final String TITLE = "노원휴먼라이브러리";

    private static final String REQUEST_HUMANBOOK = "%s 구독자가 구독신청을 하였습니다. 가능한 일정을 선택해주세요.";

    private static final String ACCEPT_HUMANBOOK = "%s 휴먼북이 구독신청을 수락하셨습니다. 휴먼북 구독날짜를 확인해주세요.";

    private static final String REJECT_HUMANBOOK = "%s 휴먼북이 구독신청을 거절하셨습니다. 거절 사유 확인 후 다시 신청해주세요.";

    private static final String COMPLETE_HUMANBOOK = "휴먼북 심사가 완료되었습니다. 심사 결과를 확인해보세요.";

    private String title;

    private String body;

    public FCMNotification(String body) {
        this.title = TITLE;
        this.body = body;
    }

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

    public static FCMNotification requestHumanbook(String subscriberName) {
        return new FCMNotification( String.format(REQUEST_HUMANBOOK, subscriberName));
    }

    public static FCMNotification acceptHumanbook(String humanbookName) {
        return new FCMNotification( String.format(ACCEPT_HUMANBOOK, humanbookName));
    }

    public static FCMNotification rejectHumanbook(String humanbookName) {
        return new FCMNotification( String.format(REJECT_HUMANBOOK, humanbookName));
    }

    public static FCMNotification completeHumanbook() {
        return new FCMNotification( COMPLETE_HUMANBOOK);
    }
}
