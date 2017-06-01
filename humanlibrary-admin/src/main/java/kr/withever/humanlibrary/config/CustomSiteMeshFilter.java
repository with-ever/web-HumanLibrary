package kr.withever.humanlibrary.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * Created by youngjinkim on 2017. 4. 26..
 */
public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {


    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder
                .addDecoratorPath("/", "/WEB-INF/view/layout/default-layout.jsp")
                .addDecoratorPath("/webview*", "/WEB-INF/view/layout/webview-layout.jsp")
                .addExcludedPath("/js/*")
                .addExcludedPath("/css/*")
                .addExcludedPath("/img/*")
                .addExcludedPath("/fonts/*")
                .addExcludedPath("/login*");
    }
}
