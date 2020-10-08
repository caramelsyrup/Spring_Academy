package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.member.model.MemberService;
import com.member.model.MemberVO;

@Controller
public class MemberController {
	// 컨테이너에 등록된 서비스와 연결
	@Autowired
	private MemberService mService;
	
	
	@RequestMapping(value = "insert.my",method = RequestMethod.GET)
	public String insert() {
		return "insertForm";
	}
	
	@RequestMapping(value = "insert.my",method = RequestMethod.POST)
	public String insert(MemberVO member) {
		mService.insert(member);
		
		return "redirect:list.my";
	}
	// 리스트 전체보기
	@RequestMapping(value = "list.my",method = RequestMethod.GET)
	public String list(Model mv) {
		List<MemberVO> list = mService.list();
		mv.addAttribute("list", list);
		return "list";
	}
	
	@RequestMapping(value = "view.my" , method = RequestMethod.GET)
	public String view(String id,Model mv) {
		MemberVO vo = mService.view(id);
		mv.addAttribute("user", vo);
		return "view";	
	}
	
	@RequestMapping(value = "update.my" , method = RequestMethod.GET)
	public String update(String id, Model mv) {
		
		MemberVO vo = mService.view(id);
		mv.addAttribute("user",vo);
		
		return "updateForm";
	}
	
	@RequestMapping(value = "update.my",method = RequestMethod.POST)
	public String update(MemberVO member) {
		mService.update(member);
		return "redirect:list.my";
	}
	
	@RequestMapping("delete.my")
	public String delete(String id) {
		
		mService.delete(id);
		
		return "redirect:list.my";
		
	}
	
	
	
	

}
