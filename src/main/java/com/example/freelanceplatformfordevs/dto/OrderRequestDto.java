package com.example.freelanceplatformfordevs.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderRequestDto {
    private String title;
    private String description;
    private Double budget;
    private LocalDate deadline; // You can use `LocalDate` or `Date` if needed
    private Long currentUserId;
}
