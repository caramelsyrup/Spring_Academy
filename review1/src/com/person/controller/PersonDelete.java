package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;

public class PersonDelete extends AbstractController {
	
	private PersonDAOImpl dao;
	
	
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// id에 저장. 넘어온 데이터를
		String id = req.getParameter("id");
		// dao의 메소드를 실행
		dao.personDelete(id);
		// 리스트를 보여주는 화면으로 이동
		return new ModelAndView("redirect:personList.sp");
	}

}
