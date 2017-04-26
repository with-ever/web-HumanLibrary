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
                .addDecoratorPath("/", "/WEB-INF/views/layout/default-layout.jsp")
//                .addDecoratorPath("/*", "/WEB-INF/views/layout/layout_default.jsp")
//                .addDecoratorPath("**popup", "/WEB-INF/views/layout/layout_popup.jsp")

                .addExcludedPath("/js/*")
                .addExcludedPath("/css/*")
                .addExcludedPath("/img/*")
                .addExcludedPath("/login*");
    }
}
