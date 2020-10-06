package com.person.model;

import java.util.List;

public interface PersonDAO {
	// 추가
	public void perInsert(Person p);
	// 전체보기
	public List<Person> perList();
	// 수정
	public void perUpdate(Person p);
	// 삭제
	public void perDelete(String id);
	// 상세보기
	public Person perView(String id);
}
