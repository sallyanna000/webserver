package com.dx.webserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Description 程序主入口
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 14:32
 */
@SpringBootApplication
@MapperScan("com.dx.webserver.dao") // mapper接口
@ServletComponentScan //项目中如果需要使用java原生的servlet和filter，可以在类中使用注解实现，主要是配置Druid监控时需要用到
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
