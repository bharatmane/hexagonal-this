package io.github.bharatmane.hexagonalthis.repository.config;

import io.github.bharatmane.hexagonalthis.domain.port.ObtainUser;
import io.github.bharatmane.hexagonalthis.repository.UserRepository;
import io.github.bharatmane.hexagonalthis.repository.dao.UserDao;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("io.github.bharatmane.hexagonalthis.repository.entity")
@EnableJpaRepositories(
        basePackages = "io.github.bharatmane.hexagonalthis.repository.dao",
        repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class JpaAdapterConfig {
    @Bean
    public ObtainUser getUserRepository(UserDao userDao) {
        return new UserRepository(userDao);
    }
}
