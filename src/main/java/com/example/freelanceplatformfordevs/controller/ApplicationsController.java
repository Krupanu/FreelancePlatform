package com.example.freelanceplatformfordevs.controller;

import com.example.freelanceplatformfordevs.model.Application;
import com.example.freelanceplatformfordevs.model.Order;
import com.example.freelanceplatformfordevs.model.OrderStatus;
import com.example.freelanceplatformfordevs.service.ApplicationService;
import com.example.freelanceplatformfordevs.service.OrdersService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
