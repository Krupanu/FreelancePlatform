package com.example.freelanceplatformfordevs.repository;

import com.example.freelanceplatformfordevs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User getUserById(Long userId);
}


