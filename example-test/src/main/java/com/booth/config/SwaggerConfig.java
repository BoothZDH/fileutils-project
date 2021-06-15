package com.booth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ClassName: SwaggerConfig
 * @Version:1.0
 * @Author booth
 * @Date: 2021/06/15/12:00
 * @Description: //TODO
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


	private ApiInfo apiInfo(){
		return new ApiInfoBuilder().title("Api接口文档")
				.description("test swagger")
				.version("1.0.0")
				.build();
	}
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.booth.myplus.controller"))
				.paths(PathSelectors.any())
				.build();
	}
}
