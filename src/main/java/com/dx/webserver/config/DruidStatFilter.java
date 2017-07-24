package com.dx.webserver.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @Description Druid拦截器，用于查看Druid监控
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:09
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",
        initParams = {
                @WebInitParam(name="exclusions", value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*") //忽略资源
        })
public class DruidStatFilter extends WebStatFilter {
}
