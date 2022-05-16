package com.webdevelopersbackend.services;


import com.webdevelopersbackend.models.DevProfile;
import com.webdevelopersbackend.models.Project;
import com.webdevelopersbackend.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ProjectService {

    private List<Project> listProjects = new ArrayList<>();

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
        listProjects.add(testProject());
    }


    private Project testProject() {
        Project project = new Project();
        project.setId(1);
        project.setName("Something");
        project.setDescription("Kindergarden");
        project.setLocation("Europe");
        project.setStartDate("12/01/2022");
        project.setEndDate("12/02/2022");
        project.setPrice(100);
        return project;
    }

    public Project getOneProject(long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        if(projectOptional.isPresent()) {
            return projectOptional.get();
        }
        throw new RuntimeException("Id invalid.");
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }
    public Project updateProject(Project project, long id){
        for (Project currentProject: listProjects){
            if (currentProject.getId() == id){
                currentProject.setName(project.getName());
                currentProject.setDescription(project.getDescription());
                currentProject.setLocation(project.getLocation());
                currentProject.setStartDate(project.getStartDate());
                currentProject.setEndDate(project.getEndDate());
                currentProject.setPrice(project.getPrice());
            }
        }
        return projectRepository.save(project);
    }
}
