package com.mycom.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberDAOImpl dao;
	
	// 추가
	@Override
	public void insert(Member member) {
		dao.dao_insert(member);
	}
	
	// 전체보기
	@Override
	public List<Member> list() {
		List<Member> list = dao.dao_list();
		return list;
	}
	
	// 상세보기
	@Override
	public Member findById(String id) {
		
		Member member = dao.dao_findById(id);
		
		return member;
	}
	
	// 수정하기
	@Override
	public void update(Member member) {
		dao.dao_update(member);
		
	}
	
	// 삭제하기
	@Override
	public void delete(String id) {
		dao.dao_delete(id);
		
	}
	// 검색보기
	@Override
	public List<Member> slist(String category, String searchInput) {
		
		List<Member>list = dao.dao_slist(category, searchInput);
		
		return list;
	}

}
