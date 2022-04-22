package com.webdevelopersbackend.services;

import com.webdevelopersbackend.models.DevProfile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DevProfileService {

    private List<DevProfile> listDevProfile = new ArrayList<>();

    public DevProfileService() {
        listDevProfile.add(testProfile());
    }

    private DevProfile testProfile() {
        DevProfile developer = new DevProfile();
        developer.setId(1);
        developer.setName("Ismar");
        developer.setSurname("Becirspahic");
        developer.setPassword("12345678");
        developer.setLocation("Germany");
        developer.setNumberOfProjectsCompleted(3);
        developer.setRecentCompletedProject("Something");
        developer.setYearsOfExperience(1);
        return developer;
    }

    public DevProfile getProfile(long id) {
        for(DevProfile developer:listDevProfile) {
            if(developer.getId() == id) {
                return developer;
            }
        }
        throw new RuntimeException("Developer does not exist");
    }

    public DevProfile deleteProfile(long id) {
        Iterator<DevProfile> iterator = listDevProfile.iterator();
        while(iterator.hasNext()) {
            DevProfile developer = iterator.next();
            if(developer.getId() == id) {
                iterator.remove();
                return developer;
            }
        }
        return null;
    }
    public DevProfile updateDevProfile(DevProfile devProfile, long id){
        for (DevProfile currentDevProfile: listDevProfile){
            if (currentDevProfile.getId() == id){
                currentDevProfile.setName(devProfile.getName());
                currentDevProfile.setSurname(devProfile.getSurname());
                currentDevProfile.setLocation(devProfile.getLocation());
                currentDevProfile.setNumberOfProjectsCompleted(devProfile.getNumberOfProjectsCompleted());
                currentDevProfile.setRecentCompletedProject(devProfile.getRecentCompletedProject());
                currentDevProfile.setPassword(devProfile.getPassword());
            }
        }
        return devProfile;
    }
}
