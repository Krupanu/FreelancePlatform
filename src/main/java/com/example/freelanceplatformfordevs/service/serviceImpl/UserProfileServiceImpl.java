package com.example.freelanceplatformfordevs.service.serviceImpl;

import com.example.freelanceplatformfordevs.model.User;
import com.example.freelanceplatformfordevs.repository.UserRepository;
import com.example.freelanceplatformfordevs.service.UserProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    private final UserRepository userRepository;

    public UserProfileServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User getUserProfileInfo(Long userId) {
        return userRepository.getUserById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}
