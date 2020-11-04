package com.example.demo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo3.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {	// Member테이블에 Id값 

}
