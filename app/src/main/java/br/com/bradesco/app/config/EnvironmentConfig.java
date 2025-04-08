package br.com.bradesco.app.config;

import br.com.bradesco.core.domain.env.Environment;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
@ConfigurationProperties(prefix="gateway.service")
public class EnvironmentConfig extends Environment {}