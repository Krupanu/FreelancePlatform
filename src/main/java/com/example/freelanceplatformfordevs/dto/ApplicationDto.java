package com.example.freelanceplatformfordevs.dto;


import com.example.freelanceplatformfordevs.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private Long id;
    private String createdAt;
    private String status;
    private String orderId;
    private String userId;
}
