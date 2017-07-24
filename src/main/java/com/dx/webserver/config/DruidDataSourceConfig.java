package com.dx.webserver.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.dx.webserver.common.log.BaseLogger;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @Description Druid的Data Source配置类
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:08
 */
@Configuration
@EnableTransactionManagement
public class DruidDataSourceConfig extends BaseLogger implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
    }

    @Bean
    public DataSource dataSource() {
        logger.info("注入druid...");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(propertyResolver.getProperty("url"));
        dataSource.setDriverClassName(propertyResolver.getProperty("driver-class-name"));
        dataSource.setUsername(propertyResolver.getProperty("username"));
        dataSource.setPassword(propertyResolver.getProperty("password"));
        dataSource.setMaxActive(Integer.valueOf(propertyResolver.getProperty("druid.max-active")));
        dataSource.setInitialSize(Integer.valueOf(propertyResolver.getProperty("druid.initial-size")));
        dataSource.setMinIdle(Integer.valueOf(propertyResolver.getProperty("druid.min-idle")));
        dataSource.setMaxWait(Integer.valueOf(propertyResolver.getProperty("druid.max-wait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(propertyResolver.getProperty("druid.time-between-eviction-runs-millis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(propertyResolver.getProperty("druid.min-evictable-idle-time-millis")));
        dataSource.setTestWhileIdle(Boolean.valueOf(propertyResolver.getProperty("druid.test-while-idle")));
        dataSource.setTestOnBorrow(Boolean.valueOf(propertyResolver.getProperty("druid.test-on-borrow")));
        dataSource.setTestOnReturn(Boolean.valueOf(propertyResolver.getProperty("druid.test-on-return")));
        try {
            dataSource.setFilters(propertyResolver.getProperty("druid.filters"));
//            dataSource.setFilters("stat,wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataSource;
    }
}
