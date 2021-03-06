package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.person.model.Person;
import com.person.model.PersonDAOImpl;

@Controller
public class PersonController {
	// 메소드 실행을 위해서 dao 변수 선언.
	// spring-servlet.xml파일과 연결을 위해 Autowired 어노테이션. container에서 찾음.
	@Autowired
	private PersonDAOImpl dao;
	// void도 가능하다. 하지만 경로의 이름과 파일 명이 동일해야 한다.
	// 전송되는 방식이 get인지 post인지에 따라서 메소드 실행을 다르게 지정.
	// GET방식은 작성 폼 화면으로 가도록
	@RequestMapping(value="personInsert.go",method=RequestMethod.GET)
	public String insert() {
		// 해당 파일의 이름으로 이동
		return "personForm";
	}
	// POST 방식은 폼의 데이터를 가지고 구체적으로 DB에 추가되도록
	@RequestMapping(value="personInsert.go",method=RequestMethod.POST)
	public String insert(Person p) {
		// 해당 메소드 실행
		dao.perInsert(p);
		// 해당 위치로 이동
		return "redirect:list.go";
	}
	
	// get방식접근으로 
	@RequestMapping("list.go")
	public ModelAndView list() {
		// list객체를 만듦. 해당 메소드의 반환 값이 리스트
		List<Person> list =  dao.perList();
		// 모델앤뷰를 이용하여 화면에 출력.
		ModelAndView mv = new ModelAndView();
		// 받은 리스트 값을 mv에 추가
		mv.addObject("list",list);
		// 화면 파일 이름
		mv.setViewName("list");
		// 리턴은 mv객체
		return mv;
	}
	
	// 상세보기
	@RequestMapping("view.go")
	public ModelAndView view(String id) {	// 웹페이지 상에서 데이터값을 가지고 오면, 그 값을 해당 함수의 매개변수로 사용.
		// perView 메소드의 반환값이 Person클래스형이기에
		Person user = dao.perView(id);
		// 값을 가지고 가서 해당 파일에 뿌리기 위해서 ModelAndView 이용.
		ModelAndView mv = new ModelAndView();
		// perView메소드의 반환 값을 추가
		mv.addObject("user",user);
		// view라는 이름의 파일에 세팅
		mv.setViewName("view");
		// ModelAndView의 객체를 반환.
		return mv;	
	}
	
	// 삭제하기
	@RequestMapping("delete.go")
	public String delete(String id) {
		// 삭제 메소드 실행
		dao.perDelete(id);
		// 해당 주소로 이동
		return "redirect:list.go";
		
	}
	
	// 수정하기, GET방식으로 접근하여, 수정 폼으로 이동
	@RequestMapping(value="update.go",method = RequestMethod.GET)
	public String update(Model mv,String id) {	// 스프링 프레임워크에서는 Model객체를 인자로 사용가능.
		// 개인 정보를 미리 화면에 세팅하기 위해서 데이터를 받아오려고 함.
		Person user = dao.perView(id);	// 데이터를 담을 객체 생성.
		mv.addAttribute("user",user);	// 데이터가 있는 객체를 화면 객체에 추가.
		return "updateForm";			// 해당 이름의 파일화면으로 실행
	}
	
	// 수정하기, 수정기능이 되도록
	@RequestMapping(value="update.go",method = RequestMethod.POST)
	public String update(Person p) {
		// 인터페이스에서 정의 해놓은 해당 메소드를 실행
		dao.perUpdate(p);
		// 실행후 리스트화면으로 이동
		return "redirect:list.go";
		
	}
	
}
