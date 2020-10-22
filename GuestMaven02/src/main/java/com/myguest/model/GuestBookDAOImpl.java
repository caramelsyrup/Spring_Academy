package com.myguest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myguest.mapper.GuestBookMapper;

@Repository
public class GuestBookDAOImpl implements GuestBookDAO {
	
	@Autowired
	private GuestBookMapper mapper;
	
	@Override
	public int dao_guestInsert(GuestBookDTO gb) {
		mapper.insert(gb);
		return 0;
	}

	@Override
	public List<GuestBookDTO> dao_list(HashMap<String, Object> hm) {
		
		return mapper.list(hm);
	}

	@Override
	public GuestBookDTO dao_findByNum(int num) {
		// TODO Auto-generated method stub
		return mapper.findByNum(num);
	}

	@Override
	public void dao_guestUpdate(GuestBookDTO gb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dao_guestDelete(int num) {
		mapper.delete(num);
	}

	@Override
	public int dao_guestCount(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return mapper.count(hm);
	}

}
