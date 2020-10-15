package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guest.mapper.GuestMapper;
import com.guest.vo.GuestVO;

@Repository
public class GuestDAOImpl implements GuestDAO{
	
	@Autowired
	private GuestMapper mapper;
	
	@Override
	public void insert(GuestVO guest) {
		mapper.insert(guest);
		
	}

	@Override
	public void update(GuestVO guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<GuestVO> list(HashMap<String, Object> hm) {
		List<GuestVO> list =  mapper.list(hm);
		return list;
	}

	@Override
	public GuestVO findById(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(HashMap<String, Object> hm) {
		// TODO Auto-generated method stub
		return 0;
	}

}
