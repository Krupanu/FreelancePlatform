package com.example.freelanceplatformfordevs.controller;

import com.example.freelanceplatformfordevs.dto.RoleDto;
import com.example.freelanceplatformfordevs.model.Role;
import jakarta.validation.Valid;
import com.example.freelanceplatformfordevs.dto.UserDto;
import com.example.freelanceplatformfordevs.model.User;
import com.example.freelanceplatformfordevs.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("index")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        UserDto user = new UserDto();
        List<RoleDto> availableRoles = new ArrayList<>() {{
            add(new RoleDto(Role.EMPLOYEE, "Заказчик"));
            add(new RoleDto(Role.FREELANCER, "Исполнитель"));
        }};
        model.addAttribute("user", user);
        model.addAttribute("availableRoles", availableRoles);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }
}