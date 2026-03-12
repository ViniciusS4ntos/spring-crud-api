package com.vinicius.spring_crud_api.infrastructure.repository;

import com.vinicius.spring_crud_api.infrastructure.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Transactional
    Optional<User> deleteByEmail(String email);

    boolean existsByEmail(String email);

}
