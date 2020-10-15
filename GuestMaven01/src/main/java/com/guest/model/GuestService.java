package com.guest.model;

import java.util.HashMap;
import java.util.List;

import com.guest.vo.GuestVO;

public interface GuestService {
	
	public void insert(GuestVO guest);
	public void update(GuestVO guest);
	public void delete(int num);
	public List<GuestVO>list(HashMap<String, Object>hm);
	public GuestVO findById(int num);
	public int count(HashMap<String, Object>hm);
}
