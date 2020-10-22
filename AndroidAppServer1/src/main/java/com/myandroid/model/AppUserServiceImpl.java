package com.myandroid.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myandroid.VO.UserVO;

@Service
public class AppUserServiceImpl implements AppUserService{
	
	@Autowired
	private AppUserDAOImpl dao;
	
	@Override
	public List<UserVO> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO findById(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int login(String userID, String password) {
		int sign = dao.dao_login(userID, password);
		return sign;
	}

}
