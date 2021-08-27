package com.ibytecode.businesslogic;

import java.util.List;

import javax.ejb.Remote;

import com.ibytecode.entities.Project;

@Remote
public interface ProjectBeanRemote {

	void saveProject(Project project);
    Project findProject(Project project);
    List<Project> retrieveAllProjects();
}
