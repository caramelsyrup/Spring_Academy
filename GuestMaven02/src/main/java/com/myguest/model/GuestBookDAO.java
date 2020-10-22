package com.myguest.model;

import java.util.HashMap;
import java.util.List;

public interface GuestBookDAO {
	// 추가
	public int dao_guestInsert(GuestBookDTO gb);
	// 전체보기
	public List<GuestBookDTO> dao_list(HashMap<String, Object>hm);
	// 상세보기
	public GuestBookDTO dao_findByNum(int num);
	// 수정
	public void dao_guestUpdate(GuestBookDTO gb);
	// 삭제
	public void dao_guestDelete(int num);
	// 개수
	public int dao_guestCount(HashMap<String, Object>hm);
	
}
