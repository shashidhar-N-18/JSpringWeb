package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;



@Configuration
@ComponentScan(basePackages = {"com.controllers","com.beans", "com.dao","com.services"})
public class WebAppConfig {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public DriverManagerDataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

		dataSource.setUrl("jdbc:mysql://localhost:3306/employee");

		dataSource.setUsername("root");

		dataSource.setPassword("$hashiSQL");

		return dataSource;

	}
	
	@Bean

	public JdbcTemplate jdbcTemplate() {

		return new JdbcTemplate(getDataSource());

	}
	


	
}
