package io.github.bharatmane.hexagonalthis.config;

import io.github.bharatmane.hexagonalthis.domain.UserDomain;
import io.github.bharatmane.hexagonalthis.domainapi.model.port.ObtainUser;
import io.github.bharatmane.hexagonalthis.domainapi.model.port.RequestUser;
import io.github.bharatmane.hexagonalthis.repository.config.JpaAdapterConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaAdapterConfig.class)
public class BootstrapConfig {

    @Bean
    public RequestUser getRequestUser(ObtainUser obtainUser) {
        return new UserDomain(obtainUser);
    }
}
