package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// 레파지토리를 등록하여, 오토와이어드와 연결. spring container에 등록이 됨.
@Repository
public class PersonDAOImpl implements PersonDAO {
	
	// 스프링에 있는 jdbc의 템플렛을 그대로 사용하기 위해서, template 변수 선언. spring container와 연결
	@Autowired
	private JdbcTemplate template;
	// 해당 변수를 세터 해준다.
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	// 추가
	@Override
	public void perInsert(Person p) {
		// sql문 작성. DB 실행을 위해서
		String sql = "INSERT INTO person VALUES (?,?,?,?,?)";
		// param 배열을 만들어서 sql문의 ?에 넣을 데이터를 빈클래스로부터 get함. 순서
		Object[] param = new Object[]{
			p.getId(), p.getName(),p.getPassword(),p.getGender(),p.getJob()
		};
		// template을 참조하여 update 메소드를 실행. 매개변수로 sql문과 param 객체 배열을 이용.실행.
		template.update(sql, param);
	}
	
	// 전체보기
	@Override
	public List<Person> perList() {
		String sql = "SELECT * FROM person";
		
		List<Person>list =  template.query(sql, new RowMapper<Person>() {
			@Override
			public Person mapRow(ResultSet rs, int resp) throws SQLException {
				Person p = new Person();
				p.setGender(rs.getString("gender"));
				p.setId(rs.getString("id"));
				p.setJob(rs.getString("job"));
				p.setName(rs.getString("name"));
				p.setPassword(rs.getString("password"));
				return p;
			}
			
		});
		return list;
	}
	
	// 수정
	@Override
	public void perUpdate(Person p) {
		// sql문 작성
		String sql = "UPDATE person SET name=?,password=?,gender=?,job=? WHERE id=?";
		// 배열 객체 사용
		Object[] param = new Object[]{
				p.getName(),p.getPassword(),p.getGender(),p.getJob(),p.getId()
			};
		template.update(sql,param);
	}
	
	// 삭제
	@Override
	public void perDelete(String id) {
		// sql문 작성
		String sql = "DELETE FROM person WHERE id ='"+id+"'";
		// 해당 구문 실행
		template.execute(sql);
	}

	// 상세보기
	@Override
	public Person perView(String id) {
		//sql문 작성
		String sql = "SELECT * FROM person WHERE id = '"+id+"'";
		// 객체에 결과 값 저장(sql문,그 결과 값)
		Person userinfo =  template.queryForObject(sql, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int arg1) throws SQLException {
				Person user = new Person();
				user.setGender(rs.getString("gender"));
				user.setId(rs.getString("id"));
				user.setJob(rs.getString("job"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		return userinfo;
	}

}
