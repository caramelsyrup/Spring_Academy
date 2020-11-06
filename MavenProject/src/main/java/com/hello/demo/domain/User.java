package com.hello.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "hotel_user", uniqueConstraints = @UniqueConstraint( columnNames = "user_account"))
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "user_name")
	@NotNull
	private String name;			// null값이 허용 되지 않게 설정.
	
	@Column(name = "user_account")	
	private String account;			// 해당열은 유니크 설정
	
	@Column(name = "user_pwd")
	@NotNull
	private String password;		// null값이 허용 되지 않게 설정.
	
	@NotNull
	private int age;				// null값이 허용 되지 않게 설정.
	
	private String gender;
	
}
