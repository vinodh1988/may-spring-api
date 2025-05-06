package com.solution.services;

import org.springframework.stereotype.Service;

@Service
public class DataService {

	 public String[] getDeveloperNames() {
		 String[] names = { "John", "Jane", "Jack", "Jill", "Joe" ,
				 "Jim", "Jerry", "Jasmine", "Jordan", "Jessica" };
		 return names;
	 }
}
