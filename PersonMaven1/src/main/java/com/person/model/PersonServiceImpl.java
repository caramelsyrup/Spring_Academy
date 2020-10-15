package com.person.model;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonDAO dao;
	
	@Override
	public List<PersonDTO> list(HashMap<String, String>hm) {
		List<PersonDTO> list = dao.dao_list("listData",hm);
		return list;
	}

	@Override
	public PersonDTO view(String id) {
		PersonDTO person	= dao.dao_view("viewData", id);
		return person;
	}

	@Override
	public void insert(PersonDTO person) {
		dao.dao_insert("insertData", person);
	}

	@Override
	public void update(PersonDTO person) {
		dao.dao_update("updateData", person);
	}

	@Override
	public void delete(String id) {
		dao.dao_delete("deleteData", id);
		
	}

	@Override
	public String countPerson() {
		String result  = dao.dao_countPerson("countData");
		return result;
	}

}
