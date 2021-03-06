package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class PersonDAOImpl implements PersonDAO{
	private JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// 추가 구체적으로
	@Override
	public void personInsert(PersonDTO DTO) {
		
		String sql = "insert into person values(?,?,?,?,?)";
		
		Object[] param = new Object[] {
				DTO.getId(),DTO.getName(),DTO.getPassword(),
				DTO.getGender(),DTO.getJob()
		};
		template.update(sql, param);
		
	}
	// 전체보기 구체적으로
	@Override
	public List<PersonDTO> findAll() {
		// db에서 조회하는 sql문 만들고
		String sql = "select * from person";
		// list객체의 personlist를 만든다. 제네릭은 PersonDTO클래스. 템플릿의 쿼리를 이용하는데, sql문과 결과 값은 RowMapper의 생성자의 리턴을 이용
		List<PersonDTO> personlist = template.query(sql, new RowMapper<PersonDTO>() {
			
			@Override
			public PersonDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				// PersonDTO의 객체 생성하여, 조회된 결과 값들을 다 담는다.
				PersonDTO dto = new PersonDTO();
				dto.setGender(rs.getString("gender"));
				dto.setId(rs.getString("id"));
				dto.setJob(rs.getString("job"));
				dto.setName(rs.getString("name"));
				dto.setPassword(rs.getString("password"));
				// 다 담고나면 반환
				return dto;
			}
		});
		// 담는 과정이 끝나면, 해당 리스트 객체를 반환
		return personlist;
	}
	
	// 수정하기
	@Override
	public void personUpdate(PersonDTO DTO) {
		
		String sql = "update person set password=?,name=?,gender=?,job=? where id=?";
		
		Object[] param = new Object[] {
				DTO.getPassword(),DTO.getName(),
				DTO.getGender(),DTO.getJob(),DTO.getId()
		};	
		template.update(sql,param);
	}
	
	// 삭제하기
	@Override
	public void personDelete(String id) {
		
		String sql = "delete from person where id = '"+id+"'";
		
		template.execute(sql);
	}
	// 상세보기
	@Override
	public PersonDTO findbyId(String id) {
		// db에서 실행할 쿼리문 작성
		String sql = "select * from person where id ='"+id+"'";
		// person객체에 db의 결과 값을 저장. 템플릿의 쿼리포오브젝트메소드 사용.
		PersonDTO person = template.queryForObject(sql, new RowMapper<PersonDTO>() {

			@Override
			public PersonDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				// DTO객체를 만든뒤, db의 결과 값을 다 저장.
				PersonDTO user = new PersonDTO();
				user.setGender(rs.getString("gender"));
				user.setId(rs.getString("id"));
				user.setJob(rs.getString("job"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				// 저장이 끝나면 DTO객체 반환
				return user;
			}
			
		});
		// 저장된 person객체 반환.
		return person;
	}

}
