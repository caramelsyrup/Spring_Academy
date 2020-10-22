package com.guest.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guest.vo.GuestVO;

@Service
public class GuestServiceImpl implements GuestService {
	
	@Autowired
	private GuestDAO dao;
	
	@Override
	public void insert(GuestVO guest) {
		dao.insert(guest);
		
	}

	@Override
	public void update(GuestVO guest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int num) {
		dao.delete(num);
	}

	@Override
	public List<GuestVO> list(HashMap<String, Object> hm) {
		List<GuestVO> list = dao.list(hm);
		return list;
	}

	@Override
	public GuestVO findById(int num) {
		
		return dao.findById(num);
	}

	@Override
	public int count(HashMap<String, Object> hm) {
		return dao.count(hm);
	}

}
