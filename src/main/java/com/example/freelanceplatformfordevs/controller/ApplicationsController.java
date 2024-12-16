package com.example.freelanceplatformfordevs.controller;

import com.example.freelanceplatformfordevs.dto.OrderRequestDto;
import com.example.freelanceplatformfordevs.model.Application;
import com.example.freelanceplatformfordevs.model.Order;
import com.example.freelanceplatformfordevs.model.OrderStatus;
import com.example.freelanceplatformfordevs.service.ApplicationService;
import com.example.freelanceplatformfordevs.service.OrdersService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ApplicationsController {
    private final OrdersService ordersService;
    private final ApplicationService applicationService;

    public ApplicationsController (OrdersService ordersService, ApplicationService applicationService){
        this.ordersService = ordersService;
        this.applicationService = applicationService;
    }

    @PostMapping("/order/{orderId}/applications/{applicationId}")
    public void SelectFreelancer(@PathVariable Long orderId, @PathVariable Long applicationId) {
        Order order = ordersService.getOrderInfo(orderId);
        List<Application> applications = order.getApplications();

        order.setStatus(OrderStatus.APPROVED);
        applicationService.updateApplications(applications, applicationId);
    }

    @PostMapping("/order/{orderId}/new-application/{userId}")
    public void Apply(@PathVariable Long orderId, @PathVariable Long userId) {
        applicationService.addApplication(orderId, userId);
    }

    @PostMapping("order/create")
    public Long createOrder(@RequestBody OrderRequestDto orderRequest) throws  URISyntaxException {
        Order newOrder = new Order();
        newOrder.setTitle(orderRequest.getTitle());
        newOrder.setDescription(orderRequest.getDescription());
        newOrder.setBudget(orderRequest.getBudget());
        newOrder.setDueDate(orderRequest.getDeadline());
        newOrder.setCreatedAt(LocalDate.now());
        newOrder.setStatus(OrderStatus.IN_PROGRESS);
        
        Order order = ordersService.addOrder(newOrder, orderRequest.getCurrentUserId());
        return order.getId();
    }
}
