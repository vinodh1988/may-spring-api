package com.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.solution.services.DataService;
import com.solution.states.ApplicationState;
import com.solution.states.SessionState;

@Controller
@RequestMapping("/web")
public class WebController {
	
	@Autowired
	private DataService dataService;
	
	@Autowired
	private SessionState ss;
	
	
	@Autowired
	private ApplicationState as;

	@RequestMapping("/hello")
	public String home(ModelMap model) {
		String[] names = dataService.getDeveloperNames();
        ss.setState();
        as.setState();
		model.addAttribute("names", names);
		model.addAttribute("ss", ss.getState());
		model.addAttribute("as", as.getState());
		return "home";
	}

}
