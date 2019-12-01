/*package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="spring")
public class DatabaseConfig {
	
	Db db;
	@Data
	static class Db{
		String url;
		String username;
		String password;
		String driverClassName;
	}
	Jpa jpa;
	@Data
	static class Jpa{
		String showSql;
		String generateDdl;
	}

}
*/