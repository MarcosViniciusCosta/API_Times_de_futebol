package com.futebol.times.times_e_jogadores.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig 
{
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.futebol.times.times_e_jogadores.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(buildApiInfo());
	}
	
	
	private ApiInfo buildApiInfo()
	{
		return new ApiInfoBuilder()
				.title("API dos times de futebol")
				.description("Rest API de persistencia e manipulação de times de futebol")
				.contact(new Contact(
						"Marcos Vinicius",
						"https://github.com/MarcosViniciusCosta"
						,null))
				.version("1.0.0")
				.build();
	}
}
