package kr.withever.humanlibrary.domain.common.client;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
public class ClientVersion {

    private Long currentVersion;

    private Long minVersion;

    private String name;

    private String url;

    public ClientVersion() {
    }

    public Long getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(Long currentVersion) {
        this.currentVersion = currentVersion;
    }

    public Long getMinVersion() {
        return minVersion;
    }

    public void setMinVersion(Long minVersion) {
        this.minVersion = minVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
