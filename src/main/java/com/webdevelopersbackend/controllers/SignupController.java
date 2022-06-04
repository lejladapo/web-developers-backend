package com.webdevelopersbackend.controllers;

import com.webdevelopersbackend.models.AppUser;
import com.webdevelopersbackend.models.entities.UserEntity;
import com.webdevelopersbackend.services.SignupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/sign-up")
public class SignupController {

    private final SignupService signupService;


    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }
    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity appUser) { return signupService.createUser(appUser);
    }
    @GetMapping
    public List<UserEntity> getUsers() {
        return this.signupService.getListDevProfile();
    }


}
