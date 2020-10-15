package com.person.model;

import java.util.HashMap;
import java.util.List;

public interface PersonService {
	// 전체보기
	public List<PersonDTO> list(HashMap<String, String>hm);
	// 상세보기
	public PersonDTO view(String id);
	// 추가
	public void insert(PersonDTO person);
	// 수정
	public void update(PersonDTO person);
	// 삭제
	public void delete(String id);
	// 개수 세기
	public String countPerson();
}
