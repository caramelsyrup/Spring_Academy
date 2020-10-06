package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class updateForm extends AbstractController {
	private PersonDAOImpl dao;
	
	
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// jsp페이지에서 해당 아이디의 정보가 오고, 이것을 문자열 객체에 저장.
		String id = req.getParameter("id");
		// id값과 일치하는 정보를 찾아서, Impl에 있는 해당 메소드를 실행하여 얻은 반환 값을 객체에 저장.
		PersonDTO person = dao.findbyId(id);
		// 모델앤뷰 객체 생성.
		ModelAndView mv = new ModelAndView();
		// 객체에 user라는 이름으로 DTO 객체 정보 저장.
		mv.addObject("user",person);
		// 출력을 위해서 구체적인 화면 파일 경로 지정.
		mv.setViewName("WEB-INF/jsp/updateForm.jsp");
		// 리턴은 mv객체
		return mv;
	}
	
	
	
}
