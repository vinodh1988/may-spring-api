package com.solution.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solution.entities.Member;
import com.solution.entities.Project;
import com.solution.exceptions.RecordAlreadyExistsException;
import com.solution.exceptions.RecordNotFoundException;
import com.solution.repositories.MemberRepository;
import com.solution.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
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
	
	public void updateMember(Member member) throws RecordNotFoundException {
		Member m = memberRepository.findByMno(member.getMno());
		if(m != null) {
			m.setName(member.getName() != null ? member.getName() : m.getName());
			m.setRole(member.getRole() != null ? member.getRole() : m.getRole());
			memberRepository.save(m);
		}
		else {
			throw new RecordNotFoundException();
		}
	}
}
/*

   pno,name, technology
        members (mno,name,role,project)
        setProject(project)) */