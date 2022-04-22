package com.webdevelopersbackend.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevProfile {
    private long id;
    private String name;
    private String surname;
    private String password;
    private String location;
    private int numberOfProjectsCompleted;
    private int yearsOfExperience;
    private String recentCompletedProject;

}
