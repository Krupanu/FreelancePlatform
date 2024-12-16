package com.example.freelanceplatformfordevs.repository;

import com.example.freelanceplatformfordevs.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
