package com.hrk.spring.data.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.hrk.spring.data.service")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.hrk.spring.data.domain"})
public class DBConfiguration {
	
		@Value("${heroku.posgres.dburl}")
		String dbUrl;
		
	    @Bean
	    public BasicDataSource dataSource() throws URISyntaxException {
	        URI dbUri = new URI(dbUrl);

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	        BasicDataSource basicDataSource = new BasicDataSource();
	        basicDataSource.setUrl(dbUrl);
	        basicDataSource.setUsername(username);
	        basicDataSource.setPassword(password);

	        return basicDataSource;
	    }
	}
