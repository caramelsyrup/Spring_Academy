package com.member.model;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private String id,pass,name,addr,memo;
	private Date reg_date;
}
