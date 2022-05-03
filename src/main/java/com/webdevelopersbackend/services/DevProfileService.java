package com.webdevelopersbackend.services;

import com.webdevelopersbackend.models.DevProfile;
import com.webdevelopersbackend.repositories.DevProfileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DevProfileService {

    private List<DevProfile> listDevProfile = new ArrayList<>();
    private final DevProfileRepository devProfileRepository;

    public DevProfileService(DevProfileRepository devProfileRepository) {
        this.devProfileRepository = devProfileRepository;
        listDevProfile.add(testProfile());
    }

    private DevProfile testProfile() {
        DevProfile developer = new DevProfile();
        developer.setId(1);
        developer.setName("Ismar");
        developer.setSurname("Becirspahic");
        developer.setLocation("Germany");
        developer.setNumberOfProjectsCompleted(3);
        developer.setRecentCompletedProject("Something");
        developer.setYearsOfExperience(1);
        return developer;
    }

    public DevProfile getProfile(long id) {
        Optional<DevProfile> devProfileOptional = devProfileRepository.findById(id);
        if(devProfileOptional.isPresent()) {
            return devProfileOptional.get();
        }
        throw new RuntimeException("Id invalid.");
    }
    public List<DevProfile> getListDevProfile() {
        return devProfileRepository.findAll();
    }

    public DevProfile deleteProfile(long id) {
        Optional<DevProfile> devProfileOptional = devProfileRepository.findById(id);
        if(devProfileOptional.isPresent()) {
            devProfileRepository.deleteById(id);
        } else {
            throw new RuntimeException("Id doesn't exist.");
        }
        return null;
    }
    public DevProfile addProfile(DevProfile devProfile) {
        return devProfileRepository.save(devProfile);
    }
    public DevProfile updateDevProfile(DevProfile devProfile, long id){
        for (DevProfile currentDevProfile: listDevProfile){
            if (currentDevProfile.getId() == id){
                currentDevProfile.setName(devProfile.getName());
                currentDevProfile.setSurname(devProfile.getSurname());
                currentDevProfile.setLocation(devProfile.getLocation());
                currentDevProfile.setNumberOfProjectsCompleted(devProfile.getNumberOfProjectsCompleted());
                currentDevProfile.setRecentCompletedProject(devProfile.getRecentCompletedProject());

            }
        }
        return devProfile;
    }
}
