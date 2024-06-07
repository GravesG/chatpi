package com.im.chatpi.common.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {
    @Bean(value = "defaultApi2")
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("统一接口")
                // 配置网站的基本信息
                .apiInfo(new ApiInfoBuilder()
                        // 网站标题
                        .title("ChatPi-接口文档")
                        // 标题后面的版本号
                        .version("v1.0.0")
                        .description("ChatPi-接口文档")
                        // 联系人信息
                        // .contact(new Contact("阿斌", "http://www.mallchat.cn", "972627721@qq.com"))
                        .build())
                .enable(true)
                .select()
                // 指定接口的位置
                .apis(RequestHandlerSelectors
                        .withClassAnnotation(RestController.class)
                )
                .paths(PathSelectors.any())
                .build();
    }
}
