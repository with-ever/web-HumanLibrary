package kr.withever.humanlibrary.domain.common.client;

import kr.withever.humanlibrary.domain.humanbook.Category;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
public class Splash {

    List<Category> categories;

    ClientVersion version;

    public Splash() {}

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public ClientVersion getVersion() {
        return version;
    }

    public void setVersion(ClientVersion version) {
        this.version = version;
    }
}
