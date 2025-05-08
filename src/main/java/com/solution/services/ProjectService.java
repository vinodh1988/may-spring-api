package com.solution.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.entities.Member;
import com.solution.entities.Project;
import com.solution.exceptions.RecordAlreadyExistsException;
import com.solution.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	public List<Project> getProjects() {
		return projectRepository.findAll();
	}
	
	public void addProject(Project project) throws RecordAlreadyExistsException {
		if(projectRepository.findByPno(project.getPno()) != null) {
			throw new RecordAlreadyExistsException();
		}
		
		for( Member b: project.getMembers())
			b.setProject(project);
		projectRepository.save(project);
	}
}
/*

   pno,name, technology
        members (mno,name,role,project)
        setProject(project)) */