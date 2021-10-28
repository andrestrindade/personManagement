package com.andre.person.management.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {     
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.andre.person.management.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(getApiInfo());                                           
    }
    
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Person APP")
                .description("Spring Boot REST API for Person Management")
                .version("1.0.0")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .contact(new Contact("", "andrestrindade@gmail.com", "andrestrindade@gmail.com"))
                .build();
    }
    
}