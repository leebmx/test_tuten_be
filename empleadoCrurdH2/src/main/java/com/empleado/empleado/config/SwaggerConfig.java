package com.empleado.empleado.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("API REST - SpringBoot - Empleado Tuten")
//				.description("El proyecto cuenta con una BD embebida H2,"
//						+ "sobre la cual se ejecutan las cunsultas del los microservicios")
//                .version("0.1")
//				.build();
//	}
//
//	@Bean
//	public Docket newApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.select()
//				.paths(regex("/.*"))
//				.build();
//	}
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.empleado.empleado.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo())
				;
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"API REST - SpringBoot - Empleado Tuten",
				"El proyecto cuenta con una BD embebida H2 que inserta 10 rgistros al momento de iniciar el proyecto, sobre la cual se ejecutan las operaciones de empleado-controller.",
				"1.0",
				"https://www.tutenlabs.com/",
				new Contact("tutenlabs", "https://www.tutenlabs.com/", "apis@tutenlabs.com"),
				"LICENSE",
				"LICENSE URL",
				Collections.emptyList()
				);
	}
}
