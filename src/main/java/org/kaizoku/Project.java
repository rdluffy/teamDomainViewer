package org.kaizoku;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private String description;
    private List<Person> persons;

    public Project(String name, String description){
        this.name = name;
        this.description = description;
        persons = new ArrayList<Person>();
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
