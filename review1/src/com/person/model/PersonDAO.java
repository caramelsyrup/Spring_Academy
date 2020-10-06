package com.person.model;

import java.util.List;

public interface PersonDAO {
	// 추가
	public void personInsert(PersonDTO DTO);
	// 전체보기
	public List<PersonDTO>findAll();
	// 수정
	public void personUpdate(PersonDTO DTO);
	// 삭제
	public void personDelete(String id);
	// 상세보기
	public PersonDTO findbyId(String id);
}
