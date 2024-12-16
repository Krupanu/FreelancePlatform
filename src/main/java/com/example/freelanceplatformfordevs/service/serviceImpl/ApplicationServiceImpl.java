package com.example.freelanceplatformfordevs.service.serviceImpl;

import com.example.freelanceplatformfordevs.model.Application;
import com.example.freelanceplatformfordevs.model.ApplicationStatus;
import com.example.freelanceplatformfordevs.model.Order;
import com.example.freelanceplatformfordevs.model.User;
import com.example.freelanceplatformfordevs.repository.ApplicationRepository;
import com.example.freelanceplatformfordevs.repository.OrderRepository;
import com.example.freelanceplatformfordevs.repository.UserRepository;
import com.example.freelanceplatformfordevs.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
private final OrderRepository orderRepository;
private final UserRepository userRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.applicationRepository = applicationRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void updateApplications(List<Application> applications, Long selectedApplicationId) {
        applications.forEach(application -> {
            if(!Objects.equals(application.getId(), selectedApplicationId)) {
                application.setStatus(ApplicationStatus.DECLINED);
            } else {
                application.setStatus(ApplicationStatus.APPROVED);
            }
        });

        applicationRepository.saveAll(applications);
    }

    @Override
    public void addApplication(Long orderId, Long userId) {
        Order order = orderRepository.getOrderById(orderId);
        User user = userRepository.getUserById(userId);

        Application newApplication = new Application();
        newApplication.setUser(user);
        newApplication.setOrder(order);
        newApplication.setCreatedAt(LocalDate.now());
        newApplication.setStatus(ApplicationStatus.IN_PROGRESS);

        applicationRepository.save(newApplication);
    }
}
