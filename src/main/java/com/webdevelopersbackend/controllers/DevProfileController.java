package com.webdevelopersbackend.controllers;

import com.webdevelopersbackend.models.DevProfile;
import com.webdevelopersbackend.services.DevProfileService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devprofile")
public class DevProfileController {

    private final DevProfileService devProfileService;

    public DevProfileController(DevProfileService devProfileService) {
        this.devProfileService = devProfileService;
    }

    @GetMapping("/{id}")
    public DevProfile getProfile(@PathVariable long id) {
        return this.devProfileService.getProfile(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProfile(@PathVariable long id) {
        DevProfile developer = devProfileService.deleteProfile(id);
        if(developer == null) {
            throw new RuntimeException("Profile does not exist");
        }
        return "Profile was deleted.";
    }
    @PutMapping("/update/{id}")
    public DevProfile updateDevProfile(@RequestBody DevProfile devProfile,@PathVariable long id){
        return devProfileService.updateDevProfile(devProfile,id);
    }
}
