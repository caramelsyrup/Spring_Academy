package com.myandroid.model;

import java.util.List;

import com.myandroid.VO.UserVO;

public interface AppUserService {
	
	// 회원 정보 조회
	public List<UserVO> list();
	// 회원 로그인
	public int login(String userID,String password);
	// 회원 정보 상세 조회
	public UserVO findById(String userID);
	// 회원 추가
	public int insert(UserVO user);
	// 회원 정보 수정
	public void update(UserVO user);
	// 회원 정보 삭제
	public void delete(String userID);

}
