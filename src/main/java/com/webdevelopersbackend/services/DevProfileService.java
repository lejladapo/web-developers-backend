package com.webdevelopersbackend.services;

import com.webdevelopersbackend.models.DevProfile;
import com.webdevelopersbackend.repositories.DevProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DevProfileService {

    private final DevProfileRepository devProfileRepository;

    public DevProfileService(DevProfileRepository devProfileRepository) {
        this.devProfileRepository = devProfileRepository;
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

    public void deleteProfile(long id) {
        devProfileRepository.deleteById(id);
    }
    public DevProfile addProfile(DevProfile devProfile) {
        return devProfileRepository.save(devProfile);
    }
    public DevProfile updateProfile(DevProfile devProfile, long id){
        getProfile(id);
        devProfile.setId(id);
        return devProfileRepository.save(devProfile);
    }
}
