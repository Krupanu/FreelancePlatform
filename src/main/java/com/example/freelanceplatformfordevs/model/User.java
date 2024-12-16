package com.example.freelanceplatformfordevs.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable=false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    @Column(nullable=false)
    private LocalDate createdAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ContactDetail contactDetail;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private UserProfile userProfile;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Application> applications;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name = "user_skills",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="skill_id", referencedColumnName="id")})
            private List<Skill> skills = new ArrayList<>();
}
