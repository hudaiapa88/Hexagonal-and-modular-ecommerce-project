package com.uc.application;

import com.uc.common.DomainComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(exclude = SecurityAutoConfiguration.class,scanBasePackages ="com.uc" )
/*@EnableJpaRepositories(basePackages = "com.uc")
@EntityScan(basePackages = "com.uc")*/

@ComponentScan(
		basePackages =
				"com.uc",
		includeFilters = {
				@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {DomainComponent.class})
		}
)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
