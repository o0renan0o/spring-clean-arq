package br.com.app;

import br.com.app.config.EnvironmentConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(EnvironmentConfig.class)
@SpringBootApplication
public class TeachApplication {
    public static void main(String[] args) {
        SpringApplication.run(TeachApplication.class, args);
    }

}