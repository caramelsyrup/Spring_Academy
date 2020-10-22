package com.myandroid.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myandroid.VO.UserVO;
import com.myandroid.mapper.AppUserMapper;

@Repository
public class AppUserDAOImpl implements AppUserDAO {
	
	@Autowired
	private AppUserMapper mapper;
	
	@Override
	public List<UserVO> dao_list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO dao_findById(String userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dao_insert(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dao_update(UserVO user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dao_delete(String userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int dao_login(String userID, String password) {
		if(mapper.login(userID, password)!=null) {	// 아이디 존재.
			if(mapper.login(userID, password).getPassword().equals(password)) {
				return 0;	// 아이디와 비밀번호가 일치
			}
			return 1;		// 아이디 존재, 비밀번호 불일치
		}else {
			return -1;		// 아이디 존재하지 않음.
		}
	}

}
