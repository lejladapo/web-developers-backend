package com.webdevelopersbackend.controllers;

import com.webdevelopersbackend.models.Project;
import com.webdevelopersbackend.services.ProjectService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public Project getOneProject(@PathVariable long id) {
        return this.projectService.getOneProject(id);
    }
}
