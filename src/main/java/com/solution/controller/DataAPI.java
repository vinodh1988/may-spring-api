package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Person;
import com.solution.services.DataService;

@RestController
@RequestMapping("/api/data")
public class DataAPI {

	@Autowired 
	private DataService dataService;
	@GetMapping("")
    public List<Person> getPeople() {
		return dataService.getPeople();
	}
	
}
