package com.webdevelopersbackend.data;

import com.webdevelopersbackend.models.Project;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProjectTest {

    public static Project project() {
        Project project = new Project();
        project.setId(7L);
        project.setName("DS.ba");
        project.setDescription("Website for a DS organization");
        project.setLocation("Bosnia and Herzegovina");
        project.setStartDate("20/05/2022");
        project.setEndDate("20/08/2022");
        project.setPrice(100);
        return project;
    }
}
