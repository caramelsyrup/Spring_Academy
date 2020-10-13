package com.member.model;

import java.util.List;

public interface MemberService {
	// 추가
	public void insert(MemberDTO member);
	// 전체보기
	public List<MemberDTO>list();
	// 상세보기
	public MemberDTO findById(String id);
	// 수정
	public void update(MemberDTO member);
	// 삭제
	public void delete(String id);
}
