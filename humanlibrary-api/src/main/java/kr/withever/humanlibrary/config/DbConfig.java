package kr.withever.humanlibrary.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
@Configuration
@MapperScan(basePackages = {"kr.withever.humanlibrary.repo.mapper"})
@EnableTransactionManagement
public class DbConfig {
    @Bean
    public static BasicDataSource basicDataSource(
            @Value("${database.driver}") String driver,
            @Value("${database.url}") String url,
            @Value("${database.username}") String userName,
            @Value("${database.password}") String password
    ) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        return dataSource;
    }

    @Bean
    public static DataSourceTransactionManager dataSourceTransactionManager(BasicDataSource basicDataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(basicDataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public static SqlSessionFactory sqlSessionFactoryBean (BasicDataSource basicDataSource) throws Exception{

        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("kr.withever.humanlibrary.domain");
        sqlSessionFactoryBean.setDataSource(basicDataSource);
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources("classpath*:/mapper/*Mapper.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public static SqlSessionTemplate sqlSessionTemplate (SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
