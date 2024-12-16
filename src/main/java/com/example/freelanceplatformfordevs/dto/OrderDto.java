package com.example.freelanceplatformfordevs.dto;


import com.example.freelanceplatformfordevs.model.Order;
import com.example.freelanceplatformfordevs.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private OrderStatus value;
    private String title;

}
