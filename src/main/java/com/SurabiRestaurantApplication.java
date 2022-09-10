package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com")
@EntityScan(basePackages ="com.surabi.bean")
@EnableJpaRepositories(basePackages = "com.surabi.dao")
@EnableSwagger2
public class SurabiRestaurantApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurabiRestaurantApplication.class, args);
		System.err.println("Server running on port 9090");
	}
	
	//for  the swagger documentation
	@Bean						
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com"))
				.build();
	}

}
