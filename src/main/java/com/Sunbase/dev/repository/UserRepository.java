package com.Sunbase.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<com.Sunbase.dev.repository.User, Long> {
    Optional<com.Sunbase.dev.repository.User> findByUsername(String username);
    Optional<com.Sunbase.dev.repository.User> findByEmail(String email);
    @Query
        //("SELECT u FROM User u WHERE u.username = :username")
    com.Sunbase.dev.repository.User getUserByUsername(String username);
}
