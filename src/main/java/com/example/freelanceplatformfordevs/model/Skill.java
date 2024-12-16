package com.example.freelanceplatformfordevs.model;


import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column()
    private String title;

    @Column
    private Date createdAt;
}
