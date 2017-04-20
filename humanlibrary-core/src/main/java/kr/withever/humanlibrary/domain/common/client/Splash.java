package kr.withever.humanlibrary.domain.common.client;

import kr.withever.humanlibrary.domain.humanbook.Category;

import java.util.List;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
public class Splash<T> {

    List<Category> categories;

    T version;

    public Splash() {}

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public T getVersion() {
        return version;
    }

    public void setVersion(T version) {
        this.version = version;
    }
}
