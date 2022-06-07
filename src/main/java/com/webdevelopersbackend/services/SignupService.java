package com.webdevelopersbackend.services;

import com.webdevelopersbackend.models.entities.UserEntity;

import com.webdevelopersbackend.repositories.SignupRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupService {
    private final SignupRepository signupRepository;
    private final PasswordEncoder passwordEncoder;

    public SignupService(SignupRepository signupRepository, PasswordEncoder passwordEncoder) {
        this.signupRepository = signupRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity createUser(UserEntity appUser) {

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return signupRepository.save(appUser);
    }
    public List<UserEntity> getListDevProfile() {
        return signupRepository.findAll();
    }

}
