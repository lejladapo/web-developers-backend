package com.webdevelopersbackend.controllers;

import com.webdevelopersbackend.models.Project;
import com.webdevelopersbackend.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects() {
        return this.projectService.getProjects();
    }

    @GetMapping("/{id}")
    public Project getOneProject(@PathVariable long id) {
        return this.projectService.getOneProject(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        return "Project was deleted.";
    }

    @PostMapping
    public Project addProject(@RequestBody Project project) { return projectService.addProject(project);
    }
    @PutMapping("/update")
    public Project updateProject(@RequestBody Project project){
        return projectService.updateProject(project);
    }


}
