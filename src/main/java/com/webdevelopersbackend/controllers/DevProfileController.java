package com.webdevelopersbackend.controllers;
import com.webdevelopersbackend.models.DevProfile;
import com.webdevelopersbackend.services.DevProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class DevProfileController {

    private final DevProfileService devProfileService;

    public DevProfileController(DevProfileService devProfileService) {
        this.devProfileService = devProfileService;
    }

    @GetMapping("/{id}")
    public DevProfile getProfile(@PathVariable long id) {
        return this.devProfileService.getProfile(id);
    }

    @GetMapping
    public List<DevProfile> getProfiles() {
        return this.devProfileService.getListDevProfile();
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable long id) {
        devProfileService.deleteProfile(id);
    }
    @PostMapping("/create")
    public DevProfile addProfile(@RequestBody DevProfile profile) { return devProfileService.addProfile(profile);
    }
    @PutMapping("/update/{id}")
    public DevProfile updateProfile(@RequestBody DevProfile profile,@PathVariable long id){
        return devProfileService.updateProfile(profile,id);
    }
}
