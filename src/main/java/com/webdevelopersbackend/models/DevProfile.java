package com.webdevelopersbackend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity

@Getter
@Setter
@Table(name = "profile")
@NoArgsConstructor
@AllArgsConstructor
public class DevProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "location")
    private String location;
    @Column(name = "numberOfProjectsCompleted")
    private int numberOfProjectsCompleted;
    @Column(name = "yearsOfExperience")
    private int yearsOfExperience;
    @Column(name = "recentCompletedProject")
    private String recentCompletedProject;

}
