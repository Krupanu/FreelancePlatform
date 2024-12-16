package com.example.freelanceplatformfordevs.model;

import jakarta.persistence.*;


@Entity
@Table(name = "user_profile")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String bio;

    @Column(nullable = false)
    private Double rating;

    @Column()
    private String companyName;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
