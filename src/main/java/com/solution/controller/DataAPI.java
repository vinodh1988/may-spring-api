package com.solution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Person>> getPeople() {
		return ResponseEntity.ok(dataService.getPeople());
	}
	@PostMapping("")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		dataService.addPerson(person); 
		return new ResponseEntity(person, HttpStatus.CREATED);
	}
	
}
