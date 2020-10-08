package com.member.model;

import java.util.List;

public interface MemberDAO {
	// 추가
	public void dao_insert(String sqlID,MemberVO member);
	// 전체보기
	public List<MemberVO>dao_list(String sqlID);
	// 상세보기
	public MemberVO dao_view(String sqlID,String id);
	// 수정
	public void dao_update(String sqlID,MemberVO member);
	// 삭제
	public void dao_delete(String sqlID,String id);
}
