package com.webdevelopersbackend.services;

import com.webdevelopersbackend.models.SimpleUser;
import com.webdevelopersbackend.models.entities.UserEntity;
import com.webdevelopersbackend.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = getFullUserByUsername(userName);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), Collections.emptyList());
    }

    public SimpleUser getUserByUsername(String userName) {
        getFullUserByUsername(userName);
        return new SimpleUser(userName);
    }

    private UserEntity getFullUserByUsername(String userName) {
        return userRepository.findFirstByUsername(userName);
    }
    public UserEntity getUserProfile(long id) {
        Optional<UserEntity> devProfileOptional = userRepository.findById(id);
        if(devProfileOptional.isPresent()) {
            return devProfileOptional.get();
        }
        throw new RuntimeException("Id invalid.");
    }
    public UserEntity updateProfile(UserEntity user, long id){
        getUserProfile(id);
        user.setId(id);
        return userRepository.save(user);
    }
}