package com.webdevelopersbackend.controllers;

import com.webdevelopersbackend.models.entities.UserEntity;
import com.webdevelopersbackend.repositories.UserRepository;
import com.webdevelopersbackend.services.AppUserDetailsService;
import com.webdevelopersbackend.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class UserController {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final AppUserDetailsService userDetailsService;

    public UserController(JwtUtil jwtUtil, UserRepository userRepository, AppUserDetailsService userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }
    @GetMapping()
    public UserEntity getAppUser(@RequestHeader ( name = "Authorization") String token){
        String username = jwtUtil.extractUsername(token.substring(7));
      UserEntity user = userRepository.findFirstByUsername(username);
        return user;
    }
    @PutMapping("/{id}")
    public UserEntity updateProfile(@RequestBody UserEntity profile, @PathVariable long id){
        return userDetailsService.updateProfile(profile,id);
    }

}
