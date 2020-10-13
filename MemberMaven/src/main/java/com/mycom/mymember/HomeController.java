package com.mycom.mymember;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.model.Member;
import com.mycom.model.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService service;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 처음화면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	// 추가폼화면으로
	/* @RequestMapping(value = "insert",method = RequestMethod.GET) */
	@GetMapping("insert")
	public String insert() {
		
		return "insertForm";
		
	}
	
	// 추가하기 기능
	/* @RequestMapping(value = "insert",method = RequestMethod.POST) */
	@PostMapping("insert")
	public String insert(Member member) {
		
		service.insert(member);
		
		return "redirect:list";
	}
	
	// 전체보기 기능
	/* @RequestMapping(value = "list",method = RequestMethod.GET) */
	@GetMapping("list")
	public String list(Model mv) {
		
		List<Member> list = service.list();
		mv.addAttribute("list", list);
		
		return "list";
	}
	
	// 상세보기 기능
	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String findById(String id,Model mv) {
		
		Member member = service.findById(id);
		
		mv.addAttribute("user", member);
		
		return "view";	
	}
	
	// 수정 폼으로 이동
	@RequestMapping(value = "update",method = RequestMethod.GET)
	public String update(String id,Model mv) {
		
		Member member = service.findById(id);
		mv.addAttribute("user", member);
		
		return "updateForm";
	}
	
	// 수정하기 기능
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public String update(Member member) {
		
		service.update(member);
		
		return "redirect:list";
	}
	
	// 삭제하기 기능
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(String id) {
		service.delete(id);
		
		return "redirect:list";
	}
	// 검색기능 전체보기
	@RequestMapping("SList")
	public String slist(String category,String searchInput,Model mv) {
		
		List<Member> list = service.slist(category,searchInput);
		
		mv.addAttribute("list", list);
		
		return "list";
		
	}
	
}
