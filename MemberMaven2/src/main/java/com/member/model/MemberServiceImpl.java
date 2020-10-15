package com.member.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public void insert(MemberDTO member) {
		dao.dao_insert("insertData", member);
	}

	@Override
	public List<MemberDTO> list(HashMap<String, String>hm) {
		
		List<MemberDTO>list = dao.dao_list("listData",hm);
		return list;
	}

	@Override
	public MemberDTO findById(String id) {
		
		MemberDTO dto = dao.dao_findById("viewData", id);
		
		return dto;
	}

	@Override
	public void update(MemberDTO member) {
		dao.dao_update("updateData", member);
		
	}

	@Override
	public void delete(String id) {
		dao.dao_delete("deleteData", id);
	}

}
