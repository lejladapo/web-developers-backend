package com.webdevelopersbackend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Project {
    private long id;
    private String name;
    private String description;
    private String location;
    private String startDate;
    private String endDate;
    private int price;
}
