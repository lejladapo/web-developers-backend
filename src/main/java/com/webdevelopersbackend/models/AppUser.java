package com.webdevelopersbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appUser")
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private List<Project> project;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "typeOfUser")
    private String typeOfUser;
    @Column(name = "location")
    private String location;
    @Column(name = "numberOfProjectsCompleted")
    private int numberOfProjectsCompleted;
    @Column(name = "yearsOfExperience")
    private int yearsOfExperience;
}
