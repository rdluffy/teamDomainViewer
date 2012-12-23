package org.kaizoku;

import org.fest.assertions.Assertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.*;

public class MainTest {
    Project project;
    Domain domain;
    Person person;

    @BeforeMethod
    private void setUp(){
        String name = "IA";
        String description = "Intelligence artificielle";
        domain = new Domain(name, description);

        String nameProject = "IA project";
        String descriptioProject = "Pouet";
        project = new Project(nameProject, descriptioProject);

        String nameUser = "npelloux";
        person = new Person(nameUser);
    }

    @Test
    public void should_Create_Domain() {
        String name = "IA";
        String description = "Intelligence artificielle";
        domain = new Domain(name, description);

        assertThat(domain.getName()).isEqualTo(name);
        assertThat(domain.getDescription()).isEqualTo(description);
    }

    @Test
    public void should_Create_Project() {
        String name = "IA project";
        String description = "Pouet";
        project = new Project(name, description);

        assertThat(project.getName()).isEqualTo(name);
        assertThat(project.getDescription()).isEqualTo(description);
    }

    @Test
    public void should_Create_User() {
        String name = "npelloux";
        person = new Person(name);

        assertThat(person.getName()).isEqualTo(name);
    }

    @Test
    public void should_Add_Project_To_Domain() {
        domain.addProject(project);

        assertThat(domain.getProject(0)).isEqualTo(project);
    }

    @Test
    public void should_Add_User_To_Project() {
        project.getPersons().add(person);

        assertThat(project.getPersons().get(0)).isEqualTo(person);
    }
}
