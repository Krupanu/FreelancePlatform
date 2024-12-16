package com.example.freelanceplatformfordevs.service;

import com.example.freelanceplatformfordevs.dto.UserDto;
import com.example.freelanceplatformfordevs.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}