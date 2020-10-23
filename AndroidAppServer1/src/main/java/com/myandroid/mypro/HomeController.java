package com.myandroid.mypro;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.myandroid.VO.UserVO;
import com.myandroid.model.AppUserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private AppUserServiceImpl service;
	
	/*
	 * @GetMapping("/") public String Home() { return "home"; }
	 */
	
	@PostMapping("login")	// 로그인
	@ResponseBody
	public int login(String userID,String password) {
		int sign = service.login(userID, password);
		return sign;
	}
	
	@PostMapping(value = "signUp", produces = "application/json; charset=UTF-8")	// 회원가입
	@ResponseBody
	public int signUp(String objJson) {	// Json형식을 String형으로 받기에 매개변수를 String형
		System.out.println("====회원가입====");
		int result=0;
		Gson gson = new Gson();
		try {
			UserVO vo = gson.fromJson(objJson, UserVO.class);
			result = service.insert(vo);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
