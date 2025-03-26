package com.server.productionserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan("com.server.productionserver.model")
@EnableJpaRepositories("com.server.productionserver.DAO")
public class ProductionServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProductionServerApplication.class, args);
	}

}
