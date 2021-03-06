package com.member.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

// 레파지토리를 해서 컨테이너에 해당 메소드들을 저장.
@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// 이미 컨테이너에 저장되어 있는 것과 연결
	@Autowired
	private JdbcTemplate template;
	
	// 세터 설정
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// 전체보기
	@Override
	public List<MemberDTO> getMemberList() {
		String sql = "SELECT * FROM springmember";
		
		List<MemberDTO> list = template.query(sql, new RowMapper<MemberDTO>() {

			@Override
			public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberDTO dto = new MemberDTO();
				dto.setAddr(rs.getString("addr"));
				dto.setId(rs.getString("id"));
				dto.setMemo(rs.getString("memo"));
				dto.setName(rs.getString("name"));
				dto.setPass(rs.getString("pass"));
				dto.setReg_date(rs.getString("reg_date"));
				return dto;
			}
		});
		return list;
	}

	// 상세보기
	@Override
	public MemberDTO findById(String id) {
		
		// sql문
		String sql = "SELECT * FROM springmember WHERE id ='"+id+"'";
		
		MemberDTO dto = template.queryForObject(sql, new RowMapper<MemberDTO>() {

			@Override
			public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
				MemberDTO mem = new MemberDTO();
				mem.setAddr(rs.getString("addr"));
				mem.setId(rs.getString("id"));
				mem.setMemo(rs.getString("memo"));
				mem.setName(rs.getString("name"));
				mem.setPass(rs.getString("pass"));
				mem.setReg_date(rs.getString("reg_date"));
				return mem;
			}
			
		});
		return dto;
	}
	
	// 추가하기
	@Override
	public void insert(MemberDTO user) {
		// SQL문
		String sql = "INSERT INTO springmember VALUES (?,?,?,?,?,sysdate)";
		// ?에 들어갈 정보들을 빈객체로부터 얻기. 순서대로.
		Object[] param = new Object[] {
			user.getId(),user.getPass(),user.getName(),user.getAddr(),user.getMemo()
		};
		// jdbc템플릿의 메소드를 이용해서 실행.
		template.update(sql, param);
	}
	
	// 수정하기
	@Override
	public void update(MemberDTO user) {
		String sql = "UPDATE springmember SET pass=?,name=?,addr=?,memo=?,reg_date=sysdate WHERE id=?";
		Object[] param = new Object[] {
			user.getPass(),user.getName(),user.getAddr(),user.getMemo(),user.getId()	
		};
		template.update(sql,param);
	}

	// 삭제하기
	@Override
	public void delete(String id) {
		// SQL문
		String sql = "DELETE FROM springmember WHERE id ='"+id+"'";
		// sql문 실행
		template.execute(sql);
	}

}
