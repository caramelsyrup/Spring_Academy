package com.example.demo3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity	// 테이블을 자동으로 만듦. 매니저에 객체가 들어간다.
// @Table 은 테이블 명을 따로 설정. 없으면 함수명이 테이블 명
public class Member {
	// Id는 기본키로 하고, 증가는 DB에 맞게 해주겠다.
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// name은 아무것도 없기에, 그냥 name
	private String name;
	// Column은 컬럼 명을 address로
	@Column(name="address")
	private String addr;
	
	

}
