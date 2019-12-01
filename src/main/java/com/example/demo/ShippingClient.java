package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import brave.sampler.Sampler;

@EnableJpaRepositories(basePackages= {"com.example.demo.dao"})
@EntityScan(basePackages= {"com.example.demo.dto"})
@EnableEurekaClient
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class} )
@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass=false)
@EnableAspectJAutoProxy(proxyTargetClass=false)
public class ShippingClient {

	@Bean
	public Sampler sampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	//@Autowired DatabaseConfig cfg;
	
	public static void main(String[] args) {
		SpringApplication.run(ShippingClient.class, args);
	}
	/*
	@Bean
	//@Primary
	public DataSource datasource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setUrl(cfg.getDb().getUrl());
		ds.setDriverClassName(cfg.getDb().getDriverClassName());
		ds.setPassword(cfg.getDb().getPassword());
		ds.setUsername(cfg.getDb().getUsername());
		return ds;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() throws IOException {
		return factory().unwrap(EntityManagerFactory.class);
	}
	
	public SessionFactory factory() throws IOException {
		LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
		bean.setDataSource(datasource());
		bean.setPackagesToScan("com.example.demo.dto");
		Properties prop = new Properties();
		prop.setProperty(Environment.HBM2DDL_AUTO, "create");
		prop.setProperty(Environment.DIALECT, PostgreSQL9Dialect.class.getName());
		bean.setHibernateProperties(prop);
		bean.afterPropertiesSet();
		return bean.getObject();
	}*/

}
