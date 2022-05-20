package com.webdevelopersbackend.services;


import com.webdevelopersbackend.models.Project;
import com.webdevelopersbackend.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getOneProject(long id) {
        return getEntity(id);
    }

    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project, long id){
        getEntity(id);
        project.setId(id);
        return projectRepository.save(project);
    }

    private Project getEntity(long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if(projectOptional.isPresent()) {
            return projectOptional.get();
        }
        throw new RuntimeException("Project with that id does not exist.");
    }
}
