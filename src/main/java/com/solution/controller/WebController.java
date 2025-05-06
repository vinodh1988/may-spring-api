package com.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solution.services.DataService;

@Controller
@RequestMapping("/web")
public class WebController {
	
	@Autowired
	private DataService dataService;

	@RequestMapping("/hello")
	public String home(ModelMap model) {
		String[] names = dataService.getDeveloperNames();
		model.addAttribute("names", names);
		return "home";
	}

}
