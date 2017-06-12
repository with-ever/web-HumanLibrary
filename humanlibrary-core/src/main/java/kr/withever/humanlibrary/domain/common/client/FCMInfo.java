package kr.withever.humanlibrary.domain.common.client;

import kr.withever.humanlibrary.domain.user.User;

/**
 * Created by youngjinkim on 2017. 6. 12..
 */
public class FCMInfo {

    private String deviceId;

    private String token;

    /** {@link ClientPlatform} **/
    private String platform;

    private User user;

    /** sandbox: 3, production: 1*/
    private String type;

    private String version;

    private String sid;

    public FCMInfo() {
    }

    public FCMInfo(String deviceId, String token, String platform) {
        this.deviceId = deviceId;
        this.token = token;
        this.platform = platform;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

}
