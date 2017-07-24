package com.dx.webserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @Description swagger-ui配置文件
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 14:40
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket testAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dx.webserver"))
                .paths(regex("/*/.*")) //PathSelectors.any()
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "DPI Project Spring Boot REST API",
                "spring boot + mybatis + druid + mysql + swagger2",
                "1.0",
                "Terms of service",
                new Contact("dx", "https://springframework.guru/about/", "john@springfrmework.guru"),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");

    }
}
