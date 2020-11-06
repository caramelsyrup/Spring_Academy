package com.example.demo3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public String list(Model m, @PageableDefault (size=3,sort="id",direction = Sort.Direction.DESC) Pageable pageable) {
		
		// 파라미터 값이 더 있을 경우에는 List를쓴다
		// List<Member>~ 같이
		Page<Member> mlist = mservice.mlist(pageable);
		Long total = mlist.getTotalElements();
		m.addAttribute("list",mlist);
		m.addAttribute("total", total);
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
	
	// 수정을 위한 폼으로
	@GetMapping("update/{id}")
	public String updateform(@PathVariable Long id,Model m) {
		Member mb = (Member) mservice.view(id);
		m.addAttribute("user", mb);
		return "update";
	}
	
	// 수정기능 실행
	@PutMapping("update/{id}")
	@ResponseBody
	public String update(@PathVariable Long id, @RequestBody Member mem) {
		System.out.println(mem.getName());
		System.out.println(mem.getAddr());
		System.out.println(mem.getId());
		mservice.update(mem);
		return id.toString();
	}
}
