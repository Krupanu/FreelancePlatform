package com.example.freelanceplatformfordevs.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contact_details")
public class ContactDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double phoneNumber;

    @Column()
    private String email;

    @Column
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
}
