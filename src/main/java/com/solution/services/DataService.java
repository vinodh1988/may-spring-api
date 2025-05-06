package com.solution.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.solution.entities.Person;

@Service
public class DataService {
	
	List<Person> people = new ArrayList<Person>();
	DataService() {
		people.add(new Person(1,"John", "Chennai"));
		people.add(new Person(2,"Jane", "Bangalore"));
		people.add(new Person(3,"Jack", "Mumbai"));
		
	}

	 public String[] getDeveloperNames() {
		 String[] names = { "John", "Jane", "Jack", "Jill", "Joe" ,
				 "Jim", "Jerry", "Jasmine", "Jordan", "Jessica" };
		 return names;
	 }
	 
	 public List<Person> getPeople() {
		 return people;
	 }
	 public void addPerson(Person person) {
		 people.add(person);
	 }
	 
}
