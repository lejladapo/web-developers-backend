package com.webdevelopersbackend.controllers;

import com.webdevelopersbackend.models.AppUser;
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
    public AppUser createUser(@RequestBody AppUser appUser) { return signupService.createUser(appUser);
    }
    @GetMapping
    public List<AppUser> getUsers() {
        return this.signupService.getListDevProfile();
    }


}
