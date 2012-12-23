package org.kaizoku;

import java.util.ArrayList;
import java.util.List;

public class Domain {
    private String name;
    private String description;
    private List<Project> projectList;
    private Integer size;

    public Domain(String name, String description){
        this.size = 100;
        this.name = name;
        this.description = description;
        projectList = new ArrayList<Project>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject(int index) {
        return projectList.get(index);
    }

    public void addProject(Project project) {
        this.projectList.add(project);
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
