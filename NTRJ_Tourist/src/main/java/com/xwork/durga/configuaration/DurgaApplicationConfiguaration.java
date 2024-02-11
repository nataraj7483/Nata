package com.xwork.durga.configuaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
@ComponentScan("com.xwork.durga")
public class DurgaApplicationConfiguaration {
	
	public DurgaApplicationConfiguaration() {
		System.out.println("Created"+getClass().getSimpleName());
	}
	@Bean
	public ViewResolver viewResolver() {
		
		System.out.println("Registering ViewResolver");
		return new InternalResourceViewResolver("/", ".jsp");
		
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		System.out.println("Registering localContainerEntityManagerFactoryBean");
		return new LocalContainerEntityManagerFactoryBean();
	}

}
