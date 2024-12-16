package com.example.freelanceplatformfordevs.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "order")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(nullable = false)
    private LocalDate createdAt;

    @Column(nullable = false)
    private LocalDate dueDate;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double budget;

    @Column(nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
    private List<Application> applications;
}
