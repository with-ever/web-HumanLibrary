package kr.withever.humanlibrary.domain.common.client;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
public class IOSVersion extends ClientVersion{

    public IOSVersion() {
        super();
    }

    private String storeUrl;

    public String getStoreUrl() {
        return storeUrl;
    }

    public void setStoreUrl(String storeUrl) {
        this.storeUrl = storeUrl;
    }
}
