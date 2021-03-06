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
		// 인서트 폼으로 가도록, 나머지 경로 설정은 memberapp-servlet.xml에서 미리 설정을 해놓았다. 파일이름만 적으면 됨.
		return "insertForm";
		// 다른 방법으로는 void를 해서 비워두면, 어노테이션의 해당 주소로 실행이 된다.
	}
	
	// 추가하기, post 방식으로 접근했을 시, 실제 데이터 베이스에 입력되도록 구체적인 메소드 실행
	@RequestMapping(value = "member_insert.me",method = RequestMethod.POST)
	public String insert(MemberDTO user)	{
		// 인서트메소드 실행.
		dao.insert(user);
		// 실행이 끝나고나면, 해당 경로로 이동
		return "redirect:member_list.me";
	}
	
	// 전체보기
	@RequestMapping("member_list.me")
	public String list(Model mv) {	// Model 객체를 이용해서, 데이터를 화면에 뿌릴수 있도록 담는다.
		// getMemberList메소드의 반환값이 list형이기 때문에.
		List<MemberDTO> list = dao.getMemberList();
		// Model객체에 list라는 이름으로 위의 데이터를 추가.
		mv.addAttribute("list",list);
		// list파일이름 경로로 이동.
		return "list";
		
	}
	
	// 상세보기
	@RequestMapping("member_view.me")
	public String view(Model mv , String id) {	// 아이디와 모델 객체를 매개변수로
		// dao의 매소드 실행
		MemberDTO dto = dao.findById(id);
		// 모델 객체에 데이터 추가
		mv.addAttribute("user",dto);
		// view파일로 이동
		return "view";
	}
	
	// 삭제하기
	@RequestMapping("member_delete.me")
	public String delete(String id) {
		// dao의 메소드 실행
		dao.delete(id);
		// 해당 경로로 이동
		return "redirect:member_list.me";
	}
	
	// 수정하기 get방식은 폼으로 이동
	@RequestMapping(value = "member_update.me",method = RequestMethod.GET)
	public String update(Model m, String id) {
		// dao메소드를 이용해서 입력된 id와 관련된 데이터만 저장.
		MemberDTO user = dao.findById(id);
		// 모델 객체에 추가.
		m.addAttribute("user",user);
		// 해당 파일로 이동
		return "updateForm";	
	}
	
	// 수정하기 post방식은 메소드 실행. 리스트화면으로,
	@RequestMapping(value = "member_update.me",method = RequestMethod.POST)
	public String update(Model m, MemberDTO user) {
		// DTO객체에 있는 정보를 해당 메소드에 이용하여, 실행.
		dao.update(user);
		// 해당 경로로 이동.
		return "redirect:member_list.me";
	}
	
}
