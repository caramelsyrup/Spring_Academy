package com.guest.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Insert;

import com.guest.vo.GuestVO;

public interface GuestMapper {
	
	// sql문을 하나의 메서드 형태로
	// 추가
	@Insert("insert into guestbook values(guestbook_seq.nextval,#{writter},#{content},#{grade},sysdate,#{ipaddr})")
	public void insert(GuestVO guest);
	// 수정
	public void update(GuestVO guest);
	// 삭제
	public void delete(int num);
	// 전체보기
	public List<GuestVO>list(HashMap<String, Object>hm);
	// 상세보기
	public GuestVO findById(int num);
	// 개수세기
	public int count(HashMap<String, Object>hm);
	
	
}
