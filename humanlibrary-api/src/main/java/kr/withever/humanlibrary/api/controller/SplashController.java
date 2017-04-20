package kr.withever.humanlibrary.api.controller;

import kr.withever.humanlibrary.domain.common.client.AndroidVersion;
import kr.withever.humanlibrary.domain.common.client.ClientVersion;
import kr.withever.humanlibrary.domain.common.client.IOSVersion;
import kr.withever.humanlibrary.domain.common.client.Splash;
import kr.withever.humanlibrary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
@RestController
@RequestMapping(value = "/api/splash")
public class SplashController {

    @Autowired
    private CategoryService categoryService;

    // @TODO 코드리뷰.
    @RequestMapping(value = "/android", method = RequestMethod.GET)
    public Splash retrieveAndroidSplash() {
        Splash<AndroidVersion> splash = new Splash();
        AndroidVersion version = new AndroidVersion();
        createClientVersion(version);
        version.setMarketUrl("android market");
        splash.setVersion(version);
        splash.setCategories(this.categoryService.retrieveCategoriesWithSubCategory());
        return splash;
    }

    @RequestMapping(value = "/ios", method = RequestMethod.GET)
    public Splash retrieveIOSSplash() {
        Splash<IOSVersion> splash = new Splash();
        IOSVersion version = new IOSVersion();
        createClientVersion(version);
        version.setStoreUrl("ios store");
        splash.setVersion(version);
        splash.setCategories(this.categoryService.retrieveCategoriesWithSubCategory());
        return splash;
    }

    private ClientVersion createClientVersion(ClientVersion version) {
        version.setCurrentVersion(2L);
        version.setMinVersion(1L);
        version.setName("1.0.0");
        version.setUrl("hi");
        if (version instanceof AndroidVersion) {
            return (AndroidVersion) version;
        } else if (version instanceof IOSVersion) {
            return (IOSVersion) version;
        }
        return version;
    }

}
