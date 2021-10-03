package config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan({"config", "driver", "pageobjects", "stepdefinitions", "steps", "utils"})
@PropertySource("classpath:context-config.properties")
public class ContextConfig {
    @Bean
    public Faker faker() { return new Faker(); }
}
