package com.example.freelanceplatformfordevs.service;

import com.example.freelanceplatformfordevs.model.User;

import java.util.List;

public interface UserProfileService {
    User getUserProfileInfo(Long userId);
    List<User> getAllUsers();
}
