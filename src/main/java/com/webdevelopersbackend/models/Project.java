package com.webdevelopersbackend.models;

import com.webdevelopersbackend.models.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "location")
    private String location;
    @Column(name = "startDate")
    private String startDate;
    @Column(name = "endDate")
    private String endDate;
    @Column(name = "price")
    private int price;
    @Column(name = "unavailable", nullable = false)
    private boolean unavailable;
}