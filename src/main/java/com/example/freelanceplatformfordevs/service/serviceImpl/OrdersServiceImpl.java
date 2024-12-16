package com.example.freelanceplatformfordevs.service.serviceImpl;

import com.example.freelanceplatformfordevs.model.Order;
import com.example.freelanceplatformfordevs.repository.OrderRepository;
import com.example.freelanceplatformfordevs.service.OrdersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl  implements OrdersService {

    private final OrderRepository orderRepository;

    public OrdersServiceImpl (OrderRepository orderRepository){
        this.orderRepository = orderRepository;

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


}
