package com.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.member.model.MemberDAOImpl;
import com.member.model.MemberDTO;

// 컨트롤 클래스이기떄문에, 컨트롤러 어노테이션
@Controller
public class MemberController  {
	
	// 오토와이어드로 스프링컨테이너에 있을 DAOImpl와 연결
	@Autowired
	private MemberDAOImpl dao;
	
	// 추가하기, get방식으로 접근했을 때,
	@RequestMapping(value = "member_insert.me",method = RequestMethod.GET)
	public String insert() {
		// 인서트 폼으로 가도록 
		return "insertForm";
	}
	
	// 추가하기, post 방식으로 접근했을 시, 실제 데이터 베이스에 입력되도록 구체적인 메소드 실행
	@RequestMapping(value = "member_insert.me",method = RequestMethod.POST)
	public String insert(MemberDTO user)	{
		dao.insert(user);
		return "redirect:member_list.me";
	}
	
	// 전체보기
	@RequestMapping("member_list.me")
	public String list(Model mv) {
		List<MemberDTO> list = dao.getMemberList();
		mv.addAttribute("list",list);
		return "list";
		
	}
	
	// 상세보기
	@RequestMapping("member_view.me")
	public String view(Model mv , String id) {
		MemberDTO dto = dao.findById(id);
		mv.addAttribute("user",dto);
		return "view";
	}
	
	// 삭제하기
	@RequestMapping("member_delete.me")
	public String delete(String id) {
		dao.delete(id);
		return "redirect:member_list.me";
	}
	
	// 수정하기 get방식은 폼으로.
	@RequestMapping(value = "member_update.me",method = RequestMethod.GET)
	public String update(Model m, String id) {
		MemberDTO user = dao.findById(id);
		m.addAttribute("user",user);
		return "updateForm";	
	}
	
	// 수정하기 post방식은 메소드 실행. 리스트화면으로,
	@RequestMapping(value = "member_update.me",method = RequestMethod.POST)
	public String update(Model m, MemberDTO user) {
		dao.update(user);
		return "redirect:member_list.me";
	}
	
}
