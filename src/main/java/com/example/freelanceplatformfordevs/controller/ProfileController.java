package com.example.freelanceplatformfordevs.controller;


import com.example.freelanceplatformfordevs.model.User;
import com.example.freelanceplatformfordevs.service.UserProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProfileController {

    private final UserProfileService userProfileService;

    public ProfileController (UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    @GetMapping("/profile/{userId}")
    public String showProfile(Model model,@PathVariable Long userId ){
        User user = userProfileService.getUserProfileInfo(userId);
        model.addAttribute("user",user);
        return "profile";
    }

    @GetMapping("/profiles")
    public String ShowAllFreelancers (Model model){
        List<User> users = userProfileService.getAllUsers();
        model.addAttribute("users",users);

        return "all_users";
    }
}
