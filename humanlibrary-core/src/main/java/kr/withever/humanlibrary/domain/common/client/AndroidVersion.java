package kr.withever.humanlibrary.domain.common.client;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
public class AndroidVersion extends ClientVersion {

    public AndroidVersion() {
        super();
    }

    private String marketUrl;

    public String getMarketUrl() {
        return marketUrl;
    }

    public void setMarketUrl(String marketUrl) {
        this.marketUrl = marketUrl;
    }
}
