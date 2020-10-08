package com.member.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	
	// Repository 등록된 것과 연결
	@Autowired
	private MemberDAO mDAO;
	// 추가
	@Override
	public void insert(MemberVO member) {
		// mybatis 이용을 위해서 id값을 따로 지정. 해당 이름의 sql문을 실행하게 된다. 인자값은 member객체이다.
		mDAO.dao_insert("insertData", member);
	}
	// 전체보기
	@Override
	public List<MemberVO> list() {
		// mybatis 이용을 위해서 id값을 지정. 그리도 해당 sql문이 실행되고 나면, 반환 값으로 List형을 가지기에, 
		List<MemberVO> list = mDAO.dao_list("selectData");
		// List형 객체 반환
		return list;
	}

	@Override
	public MemberVO view(String id) {
		MemberVO vo = mDAO.dao_view("viewData", id);
		return vo;
	}

	@Override
	public void update(MemberVO member) {
		mDAO.dao_update("updateData", member);
		
	}

	@Override
	public void delete(String id) {
		mDAO.dao_delete("deleteData", id);
		
	}

}
