package com.dx.webserver.config;

import com.dx.webserver.common.log.BaseLogger;
import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Description PageHelper配置
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:11
 */
@Configuration
public class PageHelperConfig extends BaseLogger {

    @Bean
    public PageHelper pageHelper() {
        logger.info("===============PageHelper Configuration============");
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "pageNum=pageHelperStart;pageSize=pageHelperRows;count=countSql;");
        // 通过设置pagesize=0或者RowBounds.limit=0来查询全部结果
        properties.setProperty("pageSizeZero", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
