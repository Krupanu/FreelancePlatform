package com.example.freelanceplatformfordevs.service.serviceImpl;

import com.example.freelanceplatformfordevs.model.Order;
import com.example.freelanceplatformfordevs.model.User;
import com.example.freelanceplatformfordevs.repository.OrderRepository;
import com.example.freelanceplatformfordevs.repository.UserRepository;
import com.example.freelanceplatformfordevs.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrdersServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order getOrderInfo(Long orderId) {
        return orderRepository.getOrderById(orderId);
    }

    @Override
    public List<Order> orders() {
        return orderRepository.findAll();
    }

    @Override
    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order addOrder(Order order, Long currentUserId) {
        Optional<User> currentUser = userRepository.findById(currentUserId);
        currentUser.ifPresent(order::setCreatedBy);
        orderRepository.save(order);

        return order;
    }


}
