package com.person.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

// 서비스의 구체적 실행 메소드를 정의해놓은 클래스에 서비스 어노테이션 해놓음. spring container에 등록.
@Service
public class PersonServiceImpl implements PersonService{
	// Spring container에 Repository로 등록 해놓은 DAOImpl를 dao 객체로 선언.
	@Autowired
	private PersonDAOImpl dao;
	
	// controller에서 해당 메소드를 불러 오면, Repository의 메소드(추가)를 실행하도록. 
	@Override
	public void person_insert(PersonVO person) {
		// 해당 메소드 실행.
		dao.personInsert(person);
		
	}
	// controller에서 해당 메소드를 불러 오면, Repository의 메소드(수정)를 실행하도록. 
	@Override
	public void person_update(PersonVO person) {
		// 해당 메소드 실행.
		dao.personUpdate(person);
	}
	// controller에서 해당 메소드를 불러 오면, Repository의 메소드(삭제)를 실행하도록. 
	@Override
	public void person_delete(String id) {
		// 해당 메소드 실행.
		dao.personDelete(id);
		
	}
	// controller에서 해당 메소드를 불러 오면, Repository의 메소드(전체보기)를 실행하도록. 
	@Override
	public List<PersonVO> person_list() {
		// 해당 메소드 실행. 반환값이 List형이기 때문에 List형 객체 사용.
		List<PersonVO> list = dao.personList();
		// 객체 반환.
		return list;
	}
	// controller에서 해당 메소드를 불러 오면, Repository의 메소드(상세보기)를 실행하도록. 
	@Override
	public PersonVO person_detail(String id) {
		// 해당 메소드 실행. 반환값이 PersonVO형 이기때문에 객체 사용.
		PersonVO person  = dao.personDetail(id);
		// 객체 반환.
		return person;
	}

}
