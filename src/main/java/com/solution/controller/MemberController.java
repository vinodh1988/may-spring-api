package com.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solution.entities.Member;
import com.solution.exceptions.RecordNotFoundException;
import com.solution.services.ProjectService;
import com.solution.states.MessageFormat;

@RestController
@RequestMapping("/api/members")
public class MemberController {
	@Autowired
	private ProjectService projectService;

	  @PutMapping("")
	  public ResponseEntity<Object> updateMember(@RequestBody Member member) 
	  throws RecordNotFoundException
	  {
	    // Logic to update the member
		projectService.updateMember(member);
	    return ResponseEntity.ok(new MessageFormat("Member updated successfully",true));
	  }
}
