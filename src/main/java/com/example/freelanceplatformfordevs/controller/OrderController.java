package com.example.freelanceplatformfordevs.controller;

import com.example.freelanceplatformfordevs.dto.OrderDto;
import com.example.freelanceplatformfordevs.model.*;
import com.example.freelanceplatformfordevs.service.ApplicationService;
import com.example.freelanceplatformfordevs.service.OrdersService;
import com.example.freelanceplatformfordevs.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    private final OrdersService ordersService;
    private final UserService userService;

    public OrderController(OrdersService ordersService, UserService userService) {
        this.ordersService = ordersService;
        this.userService = userService;
    }

    @GetMapping("/order/{orderId}/applications")
    public String showOrder(Model model, @PathVariable Long orderId) {
        Order order = ordersService.getOrderInfo(orderId);
        List<OrderDto> orderStatus = new ArrayList<>() {{
            add(new OrderDto(OrderStatus.APPROVED, "Одобрено"));
            add(new OrderDto(OrderStatus.DECLINED, "Отклонено"));
        }};

        model.addAttribute("order", order);
        model.addAttribute("approvedOrderStatus", OrderStatus.APPROVED);
        model.addAttribute("approvedApplicationStatus", ApplicationStatus.APPROVED);
        model.addAttribute("declinedApplicationStatus", ApplicationStatus.DECLINED);
        model.addAttribute("status", orderStatus);
        return "applications";
    }

    @GetMapping("/order/{orderId}")
    public String showOrder(Model model, @PathVariable Long orderId, Long applicationId) {
        Order order = ordersService.getOrderInfo(orderId);
        List<OrderDto> orderStatus = new ArrayList<>() {{
            add(new OrderDto(OrderStatus.APPROVED, "Одобрено"));
            add(new OrderDto(OrderStatus.DECLINED, "Отклонено"));
        }};
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userService.findByEmail(authentication.getName());
        if (currentUser.getId() == order.getCreatedBy().getId()) {
            model.addAttribute("isOwner", true);
        } else {
            model.addAttribute("isOwner", false);
        }
        if (currentUser.getApplications().stream().anyMatch(application ->
                application.getOrder().getId() == orderId
        )) {
            model.addAttribute("alreadyApplied", true);
        } else {
            model.addAttribute("alreadyApplied", false);
        }

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("order", order);
        model.addAttribute("status", orderStatus);
        return "order";
    }

    @GetMapping("/orders")
    public String ShowAllOrders(Model model) {
        List<Order> orders = ordersService.orders();
        List<OrderDto> orderStatus = new ArrayList<>() {{
            add(new OrderDto(OrderStatus.APPROVED, "Одобрено"));
            add(new OrderDto(OrderStatus.DECLINED, "Отклонено"));
        }};


        model.addAttribute("status", orderStatus);
        model.addAttribute("orders", orders);

        return "all_orders";
    }

}
