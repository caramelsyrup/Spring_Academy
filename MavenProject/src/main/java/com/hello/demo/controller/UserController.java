package com.hello.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.demo.domain.User;
import com.hello.demo.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService uservice;
	
	// 처음 화면
	@GetMapping(value = "/")
	public String home() {
		return "home";
	}
	
	// 로그인 화면
	@GetMapping("user/login")
	public String login() {
		return "login";
	}
	
	// 회원가입 화면
	@GetMapping("user/join")
	public String join() {
		return "join";
	}
	
	// 회원가입 join버튼
	@PostMapping("user/join")
	public String mInsert(User user) {
		uservice.save(user);
		return "redirect:/user/list";
	}
	
	// 회원명단띄우기. 페이징
	@GetMapping("user/list")
	public String ulist(Model m,
			@PageableDefault(size = 3,sort = "id",direction = Direction.DESC)
			Pageable pageable) 
	{
		Page<User> list = uservice.ulist(pageable);
		m.addAttribute("list", list);
		Long count = uservice.countUser();
		m.addAttribute("count", count);
		return "ulist";
	}
	
	// 회원 삭제
	@DeleteMapping("user/delete/{id}")
	@ResponseBody
	public String userDelete(@PathVariable Long id) {
		uservice.delete(id);
		return id.toString();
	}
	
	// 상세보기
	@GetMapping("user/view/{id}")
	public String view(Model m, @PathVariable Long id) {
		User us = (User) uservice.view(id);
		m.addAttribute("user", us);
		return "view";
	}
	
	// 수정하기
	@PutMapping("user/update/{id}")
	@ResponseBody
	public String update(@PathVariable Long id,@RequestBody User us) {
		uservice.update(us);
		return id.toString();
	}
	
}
