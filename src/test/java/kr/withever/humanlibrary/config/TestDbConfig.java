package kr.withever.humanlibrary.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by youngjinkim on 2017. 2. 7..
 */
@Configuration
@ComponentScan(basePackages = {"kr.withever.humanlibrary"}, excludeFilters = @ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION))
@MapperScan(basePackages = {"kr.withever.humanlibrary.repo.mapper"})
@EnableTransactionManagement
public class TestDbConfig {

    @Bean
    public static DataSource dataSource(
    ) {
        EmbeddedDatabaseBuilder embeddedDatabase = new EmbeddedDatabaseBuilder();
        embeddedDatabase.setType(EmbeddedDatabaseType.H2);
        embeddedDatabase.addScript("/table-schema.sql");
        return embeddedDatabase.build();
    }

    @Bean
    public static DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public static SqlSessionFactory sqlSessionFactoryBean (DataSource dataSource) throws Exception{

        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setTypeAliasesPackage("kr.withever.humanlibrary.domain");
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(pathMatchingResourcePatternResolver.getResources("classpath*:/mapper/*Mapper.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public static SqlSessionTemplate sqlSessionTemplate (SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
