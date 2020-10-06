package com.person.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class PersonList extends AbstractController {
	
	private PersonDAOImpl dao;
	
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 전체보기를 위해서 List 객체를 만든다.
		List<PersonDTO> userlist = dao.findAll();
		ModelAndView mv = new ModelAndView();
		mv.addObject("userlist",userlist);
		mv.setViewName("WEB-INF/jsp/personList.jsp");
		return mv;
	}

}
