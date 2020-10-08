package com.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public void personInsert(PersonVO person) {

		String sql = "INSERT INTO person VALUES(?,?,?,?,?)";
		
		Object[] param = new Object[] {
				person.getId(),person.getName(),person.getPassword(),person.getGender(),person.getJob()
		};
		
		template.update(sql,param);
		
	}

	@Override
	public void personUpdate(PersonVO person) {
		
		String sql = "UPDATE person SET name=?,password=?,gender=?,job=? WHERE id=?";
		
		Object[] param = new Object[] {
				person.getName(),person.getPassword(),person.getGender(),person.getJob(),person.getId()
		};
		
		template.update(sql,param);
		
	}

	@Override
	public void personDelete(String id) {
		String sql = "DELETE FROM person WHERE id='"+id+"'";
		
		template.execute(sql);
	}

	@Override
	public List<PersonVO> personList() {
		
	String sql = "SELECT * FROM person";
		
		List<PersonVO> list = template.query(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO p = new PersonVO();
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

	@Override
	public PersonVO personDetail(String id) {
		String sql = "SELECT * FROM person WHERE id='"+id+"'";
		
		PersonVO person = template.queryForObject(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO vo = new PersonVO();
				vo.setGender(rs.getString("gender"));
				vo.setId(rs.getString("id"));
				vo.setJob(rs.getString("job"));
				vo.setName(rs.getString("name"));
				vo.setPassword(rs.getString("password"));
				return vo;
			}
		});
		return person;
	}

}
