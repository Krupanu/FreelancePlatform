package com.example.freelanceplatformfordevs.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_skills")
public class UserSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date createdAt;

}
