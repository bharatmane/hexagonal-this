package io.github.bharatmane.hexagonalthis.repository.config;

import io.github.bharatmane.hexagonalthis.domainapi.model.port.ObtainUser;
import io.github.bharatmane.hexagonalthis.repository.UserRepository;
import io.github.bharatmane.hexagonalthis.repository.dao.UserDao;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("io.github.bharatmane.hexagonalthis.repository.entity")
public class JpaAdapterConfig {
    @Bean
    public ObtainUser getUserRepository(UserDao userDao) {
        return new UserRepository(userDao);
    }
}
