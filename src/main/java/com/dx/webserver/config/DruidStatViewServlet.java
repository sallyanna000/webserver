package com.dx.webserver.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @Description Druid的监控servlet
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:10
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/druid/*", initParams = {
        @WebInitParam(name="allow", value="127.0.0.1,10.139.6.28/24,111.7.167.150,172.16.208.230/24"), // IP白名单（没有配置或者为空，则允许所有访问）
        @WebInitParam(name="deny", value="192.168.1.111"), // IP黑名单（存在共同时，deny优先于allow）
        @WebInitParam(name="loginUsername", value="dx"), // 用户名
        @WebInitParam(name="loginPassword", value="dx@TBD123"), //密码
        @WebInitParam(name="resetEnable", value="false") //禁用html页面上的“Reset All”功能
})
public class DruidStatViewServlet extends StatViewServlet {
}
