package com.example.freelanceplatformfordevs.service;

import com.example.freelanceplatformfordevs.model.Order;

import java.util.List;

public interface OrdersService {
    Order getOrderInfo(Long orderId);
    List<Order> orders();
    void updateOrder(Order order);
    Order addOrder(Order order, Long currentUserId);
}
