package com.webdevelopersbackend.models;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DevReport extends DevProfile{
    private long id;
    private int noOfTimesDevAppliedForPosition;
}
