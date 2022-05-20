package com.webdevelopersbackend.services;

import com.webdevelopersbackend.data.ProjectTest;
import com.webdevelopersbackend.models.Project;
import com.webdevelopersbackend.repositories.ProjectRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class ProjectServiceTest {

    @MockBean
    private ProjectRepository projectRepository;

    @TestConfiguration
    static class ItemServiceTestContextConfiguration {
        @Bean
        @Primary
        public ProjectService projectService(ProjectRepository projectRepository) {
                return new ProjectService(projectRepository);
            }
        }
    @Autowired
    private ProjectService projectService;

    @Test
    public void givenProjects_whenGetProjects_thenProjectsShouldBeFound() {
        Mockito.when(projectRepository.findAll())
                .thenReturn(List.of(ProjectTest.project()));

        List<Project> returnedList = projectService.getProjects();

        assertThat(returnedList).hasSize(1);
    }

    @Test
    public void givenNoProjects_whenGetProjects_thenListShouldBeEmpty() {
        assertThat(projectService.getProjects().isEmpty());
    }

    @Test
    public void givenProjects_whenGetProjects_thenRepositoryCalled() {
        projectService.getProjects();

        verify(projectRepository, times(1)).findAll();
    }

    @Test
    public void givenValidId_whenGetOneProject_thenProjectShouldBeFound() {
        Project project = ProjectTest.project();

        Mockito.when(projectRepository.findById(project.getId()))
                .thenReturn(Optional.of(project));

        Project resultList = projectService.getOneProject(project.getId());

        assertThat(resultList.getName())
                .isEqualTo(project.getName());
    }

    @Test
    public void givenInvalidId_whenGetOneProject_thenExceptionShouldBeThrown() {
        assertThatThrownBy(() -> projectService.getOneProject(7L))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Project with that id does not exist.");
    }

    @Test
    public void givenProject_whenGetOneProject_thenProjectReturned() {
        Project input = ProjectTest.project();
        input.setId(0L);
        Project output = ProjectTest.project();

        Mockito.when(projectRepository.save(input))
                .thenReturn(output);

        Project project = projectService.addProject(input);

        assertThat(project).isNotNull();
        assertThat(project.getName()).isEqualTo(input.getName());
    }

    @Test
    public void givenProject_whenDeleteProject_thenRepositoryCalled() {
        long id = ProjectTest.project().getId();

        projectService.deleteProject(id);

        verify(projectRepository, times(1)).deleteById(id);
    }

    @Test
    public void givenProject_whenAddProject_thenRepositoryCalled() {
        Project project = ProjectTest.project();

        projectService.addProject(project);

        verify(projectRepository, times(1)).save(project);
    }

    @Test
    public void givenProject_whenAddProject_thenIdAssigned() {
        Project input = ProjectTest.project();
        input.setId(0L);
        Project output = ProjectTest.project();

        Mockito.when(projectRepository.save(input))
                .thenReturn(output);

        Project result = projectService.addProject(input);

        assertThat(result.getId()).isNotEqualTo(0L);
    }

    @Test
    public void givenProjectAndValidId_whenUpdateProject_thenProjectReturned() {
        Project input = ProjectTest.project();
        input.setId(0L);
        long id = 2L;
        Project output = ProjectTest.project();
        output.setId(id);

        Mockito.when(projectRepository.findById(id))
                .thenReturn(Optional.of(output));
        Mockito.when(projectRepository.save(input))
                .thenReturn(output);

        Project resultItem = projectService.updateProject(input, id);

        assertThat(resultItem).isNotNull();
        assertThat(resultItem.getName()).isEqualTo(input.getName());
        assertThat(resultItem.getId()).isEqualTo(id);
    }

}
