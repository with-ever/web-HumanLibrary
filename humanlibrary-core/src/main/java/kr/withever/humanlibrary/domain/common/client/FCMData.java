package kr.withever.humanlibrary.domain.common.client;

/**
 * Created by youngjinkim on 2017. 6. 5..
 */
public class FCMData {

    private static final String DEEP_LINK_HOME = "weverhumanlib://home";
    private static final String DEEP_LINK_CONTRACT = "weverhumanlib://contract/:contractId";
    private static final String DEEP_LINK_CALENDER = "weverhumanlib://calendar";
    private static final String DEEP_LINK_ALARM = "weverhumanlib://alarm";
    private static final String DEEP_LINK_SETTING = "weverhumanlib://setting";
    private static final String DEEP_LINK_EVENT = "weverhumanlib://event";

    private static final String IMAGE_URL = "testImage";

    private String image;

    private String deeplink;

    public FCMData(String image, String deeplink) {
        this.image = image;
        this.deeplink = deeplink;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public static FCMData home() {
        return new FCMData(IMAGE_URL, DEEP_LINK_HOME);
    }

    public static FCMData contract(String contractId) {
        return new FCMData(IMAGE_URL, DEEP_LINK_CONTRACT.replaceAll(":contractId", contractId));
    }

    public static FCMData calender() {
        return new FCMData(IMAGE_URL, DEEP_LINK_CALENDER);
    }

    public static FCMData alarm() {
        return new FCMData(IMAGE_URL, DEEP_LINK_ALARM);
    }

    public static FCMData setting() {
        return new FCMData(IMAGE_URL, DEEP_LINK_SETTING);
    }

    public static FCMData event() {
        return new FCMData(IMAGE_URL, DEEP_LINK_EVENT);
    }

}
