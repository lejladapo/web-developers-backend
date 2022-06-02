package com.webdevelopersbackend.services;

import com.webdevelopersbackend.models.AppUser;
import com.webdevelopersbackend.repositories.SignupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupService{
    private final SignupRepository signupRepository;

    public SignupService(SignupRepository signupRepository) {
        this.signupRepository = signupRepository;
    }
    public AppUser createUser(AppUser appUser) {
        return signupRepository.save(appUser);
    }
    public List<AppUser> getListDevProfile() {
        return signupRepository.findAll();
    }

}
