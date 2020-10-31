package net.dietsHelper.Diets.security.config;

import net.dietsHelper.Diets.models.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
class Config {

    @Bean
    public AuditorAwareImpl auditorAware() {
        return new AuditorAwareImpl();
    }
}
