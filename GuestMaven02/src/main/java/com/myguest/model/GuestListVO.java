package com.myguest.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

// 컨트롤러에서 저장한 변수들을 다 담을 클래스를 만듦.
@Data
public class GuestListVO {
	private int count;
	private List<GuestBookDTO> list;
	private String pageHtml;
	
	// 생성자를 만듦. 매개변수들을 저장.
	// Builder lombok에 있는 순서와 상관없이 생성자 만듦.
	@Builder
	public GuestListVO(int count, List<GuestBookDTO> list, String pageHtml) {
		
		this.count = count;
		this.list = list;
		this.pageHtml = pageHtml;
		
	}
	
	
}
