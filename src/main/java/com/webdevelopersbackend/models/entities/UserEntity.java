package com.webdevelopersbackend.models.entities;

import com.webdevelopersbackend.models.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "application_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String username;
    @Column(name = "fName")
    private String firstName;
    @Column(name = "lName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

}