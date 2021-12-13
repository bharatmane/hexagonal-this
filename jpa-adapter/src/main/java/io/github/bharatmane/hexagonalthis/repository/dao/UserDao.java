package io.github.bharatmane.hexagonalthis.repository.dao;

import io.github.bharatmane.hexagonalthis.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findById(int userId);
}


