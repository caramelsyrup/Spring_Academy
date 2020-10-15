package com.guest.vo;

import java.util.Date;

import lombok.Data;

@Data
public class GuestVO {
	private int num;
	private String writter;
	private String content;
	private String grade;
	private Date created;
	private String ipaddr;
	
	
}
