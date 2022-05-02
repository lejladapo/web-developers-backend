package com.webdevelopersbackend.repositories;

import com.webdevelopersbackend.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    
}
