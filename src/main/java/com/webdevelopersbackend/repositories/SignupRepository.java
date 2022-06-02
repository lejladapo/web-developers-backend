package com.webdevelopersbackend.repositories;

import com.webdevelopersbackend.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<AppUser, Long> {

}
