package com.website.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Slf4j
@Configuration
@MapperScan(basePackages = "com.website.dao.mapper", sqlSessionTemplateRef  = "sqlSessionTemplate")
public class DataSourceConfiguration {

    @Value("${db.datasource.url}")
    private String dbUrl;
    @Value("${db.datasource.username}")
    private String dbUser;
    @Value("${db.datasource.password}")
    private String dbPassword;
    @Value("${db.datasource.initialSize:5}")
    private int initialSize;
    @Value("${db.datasource.minIdle:5}")
    private int minIdle;
    @Value("${db.datasource.maxActive:50}")
    private int maxActive;
    @Value("${db.datasource.driver-class-name}")
    private String driverClassName;

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(dbUser);
        dataSource.setPassword(dbPassword);
        //初始化连接大小
        dataSource.setInitialSize(initialSize);
        //最小空闲连接数
        dataSource.setMinIdle(minIdle);
        //最大连接数
        dataSource.setMaxActive(maxActive);
        try {
            //初始化数据库连接池
            dataSource.init();
        } catch (SQLException e) {
            log.error("build DruidDataSource has error !",e);
        }
        return dataSource;
    }

    @Bean(name = "sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return bean.getObject();
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
