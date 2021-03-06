package com.person.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;

public class PersonInsert extends AbstractController {
	private PersonDAOImpl dao;
	
	public void setDao(PersonDAOImpl dao) {
		this.dao = dao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 데이터 담는 빈 클래스의 객체를 생성.
		PersonDTO person = new PersonDTO();
		// 빈 클래스의 세터 메소드를 이용하고, req의 getParameter를 이용해서 jsp파일의 name에 해당하는 영역의 데이터 값을 가져온다.
		person.setGender(req.getParameter("gender"));
		person.setId(req.getParameter("id"));
		person.setJob(req.getParameter("job"));
		person.setName(req.getParameter("name"));
		person.setPassword(req.getParameter("pwd"));
		// 세터가 끝나고 나면, dao의 인서트에 객체 넣기.
		dao.personInsert(person);
		// 추가 작업이 끝나면 리스트화면으로 이동하도록. redirect는 관계를 끊고 페이지를 이동. spring은 기본이 forward이기 떄문에(관계를 가지고 감).
		return new ModelAndView("redirect:personList.sp");
	}

	
}
