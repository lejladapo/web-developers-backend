package com.webdevelopersbackend.services;


import com.webdevelopersbackend.models.Project;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ProjectService {

    private List<Project> listProjects = new ArrayList<Project>();

    public ProjectService() {
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
        for(Project project:listProjects) {
            if(project.getId() == id) {
                return project;
            }
        }
        throw new RuntimeException("Id invalid.");
    }

    public Project deleteProject(long id) {
        Iterator<Project> iterator = listProjects.iterator();
        while(iterator.hasNext()) {
            Project project = iterator.next();
            if(project.getId() == id) {
                iterator.remove();
                return project;
            }
        }
        return null;
    }
}
