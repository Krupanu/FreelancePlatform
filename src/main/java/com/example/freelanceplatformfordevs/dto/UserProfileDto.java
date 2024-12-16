package com.example.freelanceplatformfordevs.dto;


import com.example.freelanceplatformfordevs.model.Role;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDto {
    private Long id;
    @NotEmpty
    private String bio;
    @NotEmpty
    private String companyName;
    @NotEmpty
    private Role rating;
}
