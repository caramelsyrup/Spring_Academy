package com.mycom.model;

import java.util.Date;

import lombok.Data;

@Data
public class Member {
	
	private String id,pass,name,addr,memo;
	private Date reg_date;
	
}
