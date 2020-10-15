package com.person.model;

import java.util.HashMap;
import java.util.List;

public interface PersonDAO {
	// 전체보기
	public List<PersonDTO> dao_list(String sqlId,HashMap<String, String>hm);
	// 상세보기
	public PersonDTO dao_view(String sqlId,String id);
	// 추가
	public void dao_insert(String sqlId,PersonDTO person);
	// 수정
	public void dao_update(String sqlId,PersonDTO person);
	// 삭제
	public void dao_delete(String sqlId,String id);
	// 개수세기
	public String dao_countPerson(String sqlId);
}
