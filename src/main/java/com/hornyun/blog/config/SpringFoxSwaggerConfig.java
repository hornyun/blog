package com.hornyun.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author hornyun
 * created in 2023/05/15
 */
@EnableOpenApi
@Configuration
public class SpringFoxSwaggerConfig {
    /**
     * 配置基本信息
     * @return api info
     */
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger Test App Restful API")
                .description("swagger test app restful api")
                .termsOfServiceUrl("https://github.com/hornyun")
                .contact(new Contact("hornyun","https://github.com/hornyun","hornyun@sina.com"))
                .version("1.0")
                .build();
    }

    /**
     * 配置文档生成最佳实践
     * @param apiInfo api info
     * @return docket
     */
    @Bean
    public Docket createRestApi(ApiInfo apiInfo) {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo)
                .groupName("SwaggerGroupOneAPI")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }
}
