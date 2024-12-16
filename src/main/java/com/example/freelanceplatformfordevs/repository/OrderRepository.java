package com.example.freelanceplatformfordevs.repository;

import com.example.freelanceplatformfordevs.model.Order;
import com.example.freelanceplatformfordevs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order getOrderById (Long orderId);
}
