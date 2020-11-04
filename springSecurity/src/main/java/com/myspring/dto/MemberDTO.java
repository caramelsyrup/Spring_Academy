package com.myspring.dto;

import java.util.List;

import lombok.Data;

@Data
public class MemberDTO {
	
	private String userid;
	private String userpw;
	private String username;
	private boolean enabled;
	
	private String regdate;
	private String updatedate;
	
	// 1대 다 관계를 나타내기 위해서, 리스트형으로 정함.
	private List<AuthDTO> authList;
	
	
}
