package com.person.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.person.model.PersonService;
import com.person.model.PersonVO;

// 컨트롤러로 spring container에 등록
@Controller
public class PerController {
	
	// 등록된 서비스를 부름. 변수 선언해놓음. Impl를 해놓아도 되고, Service 인터페이스를 설정해도 된다.
	@Autowired
	private PersonService service;
	
	// get방식으로 전송된 요청을 받아서 메소드 실행
	@RequestMapping(value = "personInsert.go",method = RequestMethod.GET)
	public String insert() {
		// 등록 양식 파일을 찾아서 가도록.
		return "personForm";
	}
	// post 방식으로 전송된 요청을 받아서 메소드 실행
	@RequestMapping(value = "personInsert.go",method = RequestMethod.POST)
	public String insert(PersonVO person) {
		// 서비스에 등록된 메소드(추가)를 실행
		service.person_insert(person);
		// 모든 관계를 끊고, 해당 경로로 이동
		return "redirect:list.go";
	}
	
	// get방식으로 전송된 요청을 받아서 해당 메소드 실행
	@RequestMapping("list.go")
	public String list(Model mv) {	// Model객체를 이용해서 화면에 데이터 값을 뿌릴 수 있다.
		// 서비스에 등록된 메소드(전체보기)를 실행. 해당 메소드는 반환값이 list형이기에 그대로 맞춰준다.
		List<PersonVO> list = service.person_list();
		// Model객체에 속성 추가. list이름으로 list형의 데이터 값을 저장하여, 추가.
		mv.addAttribute("list",list);
		// list라는 이름의 파일 찾아서 감.
		return "list";
	}
	
	// get방식으로 전송된 요청을 받아서 해당 메소드 실행.
	@RequestMapping(value = "view.go",method = RequestMethod.GET)
	public String view(String id,Model mv) {	// id값을 가지고 오기 때문에, 
		// 서비스에 등록된 메소드(상세보기)를 실행. 해당 메소드는 반환값이 PersonVO형이기에 그대로 맞춰준다. (중복)
		PersonVO vo = service.person_detail(id);
		// Model객체에 속성 추가. user이름으로 PersonVO형의 데이터 값을 저장하여, 추가.
		mv.addAttribute("user", vo);
		// view라는 이름의 파일 찾아서 감.
		return "view";
	}
	
	// get방식으로 전송된 요청을 받아서 해당 메소드 실행.
	@RequestMapping(value = "update.go",method = RequestMethod.GET)
	public String update(String id, Model mv) {	// id 값과 화면에 데이터를 뿌리기 위해서 Model객체
		// 서비스에 등록된 메소드(상세보기)를 실행. 해당 메소드는 반환값이 PersonVO형이기에 그대로 맞춰준다. (중복)
		PersonVO vo = service.person_detail(id);
		// Model객체에 속성 추가. user이름으로 PersonVO형의 데이터 값을 저장하여, 추가.
		mv.addAttribute("user",vo);
		// updateForm라는 이름의 파일 찾아서 감.
		return "updateForm";	
	}
	
	// Post 방식으로 전송된 요청을 받아서 해당 메소드 실행.
	@RequestMapping(value = "update.go",method = RequestMethod.POST)
	public String update(PersonVO person) {	// 
		// 서비스에 등록된 메소드(수정하기)를 실행. 해당 메소드는 반환값이 없음. 
		service.person_update(person);
		// 해당 경로로 이동
		return "redirect:list.go";
	}
	
	// get 방식으로 전송된 요청을 받아서 해당 메소드 실행.
	@RequestMapping(value = "delete.go")
	public String delete(String id) {
		// 서비스에 등록된 메소드(삭제하기)를 실행. 해당 메소드는 반환값이 없음. 
		service.person_delete(id);
		// 해당 경로로 이동
		return "redirect:list.go";
	}
	
	/* 두개의 경로도 설정이 가능하다. 지금 로직상에서 수정하기와 상세보기는 같은 코드가 중복되기 때문에,
	 * 그리고 void로 리턴값이 없으면, 해당 경로의 파일을 찾기때문에, 파일명만 제대로 만들어 주면 거기로 이동한다.
	 * @RequestMapping(value = {"view.go","update.go"}) 
	 * public void view(Model mv ,String id) {
	 * 
	 * PersonVO person = service.person_detail(id);
	 * 
	 * mv.addAttribute("user",person); }
	 */

}
