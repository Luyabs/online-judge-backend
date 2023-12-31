package com.example.onlinejudge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 封装的Swagger文档
 * <a href="http://localhost:8080/doc.html">戳我跳转到swagger文档</a>
 */
@Configuration
public class Knife4jConfig {
    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Online Judge Api文档")
                        .description("# swagger-bootstrap-ui-demo RESTful APIs")
                        .contact(new Contact("Online Judge", "https://github.com/Luyabs/online-judge-backend", "luy@shu.edu.cn"))
                        .version("1.0")
                        .termsOfServiceUrl("http://localhost:8080/")
                        .build())
                //分组名称
                .groupName("dev")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.example.onlinejudge.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
