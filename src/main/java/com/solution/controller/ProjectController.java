package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Project;
import com.solution.services.ProjectService;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	
	@GetMapping("")
	public ResponseEntity<List<Project>> getProjects() 
	{
		
		List<Project> projects=projectService.getProjects();
		return new ResponseEntity<>(projects, HttpStatus.OK); //OK
   }

}