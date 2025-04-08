package br.com.bradesco.app;

import br.com.bradesco.app.config.EnvironmentConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(EnvironmentConfig.class)
@SpringBootApplication
public class ChaveApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChaveApplication.class, args);
    }

}