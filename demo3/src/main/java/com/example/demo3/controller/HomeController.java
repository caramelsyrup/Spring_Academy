package com.example.demo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo3.model.Member;
import com.example.demo3.service.MemberService;

@Controller
public class HomeController {
	@Autowired
	private MemberService mservice;
	
	
	@GetMapping("/")
	public String index() {
		return "home";
	}
	
	@GetMapping("mInsert")
	public String mInsert() {
		return "insert";
	}
	
	@PostMapping("mInsert")
	public String mInsert(Member member) {
		mservice.save(member);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model m) {
		m.addAttribute("list",mservice.list());
		return "list";
	}
	
	@GetMapping("{id}")
	public String view(Model m, @PathVariable Long id) {
		Member mb = (Member) mservice.view(id);
		m.addAttribute("user", mb);
		return "view";
	}
	// DeleteMapping은 a태그로 쓸수 없다. ajax에서 받아온
	@DeleteMapping("{id}")
	@ResponseBody		// 해당 번호(id)를 리턴하려고
	public String delete(@PathVariable Long id) {
		mservice.delete(id);
		return id.toString();
	}
}
