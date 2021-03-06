package com.hello.demo.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_review")
public class Review {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// 1:다의 관계에서 다의 입장.
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	private int rate;
	
	private String comment;
	
	private Date ratingDate;
	
}
