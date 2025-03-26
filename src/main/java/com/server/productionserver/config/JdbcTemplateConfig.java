package com.server.productionserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

import static com.server.productionserver.constants.DatabaseConfigConstants.DB_PASSWORD;
import static com.server.productionserver.constants.DatabaseConfigConstants.DB_URL;

@Configuration
public class JdbcTemplateConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(DB_URL);
        dataSource.setUsername("root");
        dataSource.setPassword(DB_PASSWORD);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}


