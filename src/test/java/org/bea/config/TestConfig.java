package org.bea.config;

import org.bea.repository.JdbcNativeUserRepository;
import org.bea.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class TestConfig {

    private final JdbcTemplate jdbcTemplate;

    public TestConfig(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Bean
    UserRepository userRepository() {
        return new JdbcNativeUserRepository(jdbcTemplate);
    }
}
