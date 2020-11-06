package com.example.demo3.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity(name = "tbl_user")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userid;
	
	private String username;
	
	@Column(name = "nick_name")
	private String nickname;
	
	private String address;
	
	// 양방향 관계성이 가능. 하지만 여긴 종속입장.
	@OneToMany(mappedBy = "user")
	private List<Order> orders;
}
