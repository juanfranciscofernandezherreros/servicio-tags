package com.fernandez.tags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
@ComponentScan("com.fernandez.tags.*")
@EnableSwagger2
public class TagsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TagsApplication.class, args);
	}

}
