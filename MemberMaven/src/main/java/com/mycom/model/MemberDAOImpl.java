package com.mycom.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private JdbcTemplate template;
	
	
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// 추가
	@Override
	public void dao_insert(Member member) {
		String sql = "INSERT INTO springmember VALUES (?,?,?,?,?,sysdate)";
		Object[] param = new Object[] {
			member.getId(),member.getPass(),member.getName(),member.getAddr(),member.getMemo()
		};
		template.update(sql,param);
	}
	
	// 전체보기
	@Override
	public List<Member> dao_list() {
		
		String sql = "SELECT * FROM springmember ORDER BY id";
		
		List<Member>list = template.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setAddr(rs.getString("addr"));
				mem.setId(rs.getString("id"));
				mem.setMemo(rs.getString("memo"));
				mem.setName(rs.getString("name"));
				mem.setPass(rs.getString("pass"));
				mem.setReg_date(rs.getDate("reg_date"));
				
				return mem;
			}
		});
		return list;
	}
	
	// 상세보기
	@Override
	public Member dao_findById(String id) {
		
		String sql = "SELECT * FROM springmember WHERE id = '"+id+"'";
		
		Member mem = template.queryForObject(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member m = new Member();
				m.setAddr(rs.getString("addr"));
				m.setId(rs.getString("id"));
				m.setMemo(rs.getString("memo"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getString("pass"));
				m.setReg_date(rs.getDate("reg_date"));
				return m;
			}
			
		});
		return mem;
	}
	
	// 수정하기
	@Override
	public void dao_update(Member member) {
		String sql = "UPDATE springmember SET pass=?,name=?,addr=?,memo=?,reg_date=sysdate WHERE id=?";
		Object[] param = new Object[] {
				member.getPass(),member.getName(),member.getAddr(),member.getMemo(),member.getId()
		};
		
		template.update(sql,param);
		
	}
	
	// 삭제하기
	@Override
	public void dao_delete(String id) {
		String sql = "DELETE FROM springmember WHERE id='"+id+"'";
		template.execute(sql);
	}

	@Override
	public List<Member> dao_slist(String category, String searchInput) {
		List<Member> resultList;
		String sql="";
		try {
			
			if(searchInput.equals("")) {
				sql = "SELECT * FROM springmember ORDER BY id";
			}else {
				sql = "SELECT * FROM springmember WHERE "+category+" LIKE '%"+searchInput+"%' ORDER BY id";
			}
			
			resultList = template.query(sql, new RowMapper<Member>() {

				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member m = new Member();
					m.setAddr(rs.getString("addr"));
					m.setId(rs.getString("id"));
					m.setMemo(rs.getString("memo"));
					m.setName(rs.getString("name"));
					m.setPass(rs.getString("pass"));
					m.setReg_date(rs.getDate("reg_date"));
					return m;
				}
			});
			
		}catch(Exception e) {
			e.printStackTrace();
			
			sql = "SELECT * FROM springmember ORDER BY id";
			
			resultList = template.query(sql, new RowMapper<Member>() {

				@Override
				public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
					Member m = new Member();
					m.setAddr(rs.getString("addr"));
					m.setId(rs.getString("id"));
					m.setMemo(rs.getString("memo"));
					m.setName(rs.getString("name"));
					m.setPass(rs.getString("pass"));
					m.setReg_date(rs.getDate("reg_date"));
					return m;
				}
			});
		}
		
		return resultList;
	}

}
