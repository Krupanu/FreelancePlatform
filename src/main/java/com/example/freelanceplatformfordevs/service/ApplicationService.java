package com.example.freelanceplatformfordevs.service;

import com.example.freelanceplatformfordevs.model.Application;

import java.util.List;

public interface ApplicationService {

    void updateApplications(List<Application> applications, Long selectedApplicationId);
    void addApplication(Long orderId, Long userId);
}
