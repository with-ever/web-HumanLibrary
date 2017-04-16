package kr.withever.humanlibrary.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Created by youngjinkim on 2017. 2. 21..
 */

@Configuration
@EnableResourceServer
public class WebSecurityOAuth2ResourceConfig extends ResourceServerConfigurerAdapter{

    @Value("${resource.id}")
    private String resourceId;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

        resources
                .resourceId(resourceId);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/users").hasAnyAuthority("CLIENT", "ADMIN")
                .antMatchers(HttpMethod.GET, "/api/users/verification/**").hasAnyAuthority("CLIENT", "ADMIN")
                .antMatchers("/api/users/**").hasAnyAuthority("ADMIN", "SUBSCRIBER", "HUMAN_BOOK")
//                .antMatchers("/api/test").hasAnyAuthority("CLIENT")
                .antMatchers("/api/**").hasAnyAuthority("CLIENT", "ADMIN", "SUBSCRIBER", "HUMAN_BOOK");

    }

}
