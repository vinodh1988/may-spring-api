package com.solution.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solution.entities.Member;

public interface MemberRepository  extends JpaRepository<Member, Integer> {
    public Member findByMno(Integer mno);//you can use findBy or getBy
}
