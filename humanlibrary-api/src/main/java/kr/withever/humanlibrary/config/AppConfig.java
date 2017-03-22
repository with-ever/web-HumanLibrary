package kr.withever.humanlibrary.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
@Import({DbConfig.class})
@Configuration
@ComponentScan(basePackages = {"kr.withever.humanlibrary"}, excludeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION))
public class AppConfig {

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer property = new PropertyPlaceholderConfigurer();
        property.setLocations(new Resource[]{new ClassPathResource("application.properties")});
        return property;
    }

    
    @Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
}
