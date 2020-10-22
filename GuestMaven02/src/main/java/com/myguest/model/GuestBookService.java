package com.myguest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestBookService {
	// 추가
	public int guestInsert(GuestBookDTO gb);
	// 전체보기
	public List<GuestBookDTO> list(HashMap<String, Object>hm);
	// 상세보기
	public GuestBookDTO findByNum(int num);
	// 수정
	public void guestUpdate(GuestBookDTO gb);
	// 삭제
	public void guestDelete(int num);
	// 개수
	public int guestCount(HashMap<String, Object>hm);
	
	
}
