package com.myguest.model;

import lombok.Data;

@Data
public class GuestBookDTO {
	private int num;
	private String writter;
	private String content;
	private String grade;
	private String created;
	private String ipaddr;
	
}
