package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.common.client.AndroidVersion;
import kr.withever.humanlibrary.domain.common.client.ClientVersion;
import kr.withever.humanlibrary.domain.common.client.IOSVersion;
import kr.withever.humanlibrary.domain.common.client.Splash;
import kr.withever.humanlibrary.domain.humanbook.Category;
import kr.withever.humanlibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
@RestController
@RequestMapping(value = "/api/splash")
public class SplashController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/android", method = RequestMethod.GET)
    public Splash retrieveAndroidSplash() {
        Splash splash = new Splash();
        ClientVersion version = new AndroidVersion();
        splash.setVersion(createClientVersion(version));
        splash.setCategories(this.categoryService.retrieveCategoriesWithSubCategory());
        return splash;
    }

    @RequestMapping(value = "/ios", method = RequestMethod.GET)
    public Splash retrieveIOSSplash() {
        Splash splash = new Splash();
        ClientVersion version = new IOSVersion();
        splash.setVersion(createClientVersion(version));
        splash.setCategories(this.categoryService.retrieveCategoriesWithSubCategory());
        return splash;
    }

    private ClientVersion createClientVersion(ClientVersion version) {
        version.setCurrentVersion(2L);
        version.setMinVersion(1L);
        version.setName("1.0.0");
        version.setUrl("hi");
        return version;
    }

    private List<Category> createCategoryList() {
        List<Category> categories = new ArrayList<Category>();
        for (int index = 0; index < 10; index++) {
            Category category = new Category((long)index, String.valueOf(index), "123" + index);
            categories.add(category);
        }
        return categories;
    }
}
