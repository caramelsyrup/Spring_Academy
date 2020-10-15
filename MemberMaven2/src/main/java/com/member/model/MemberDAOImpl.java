package com.member.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSessionFactory sqlMapper;

	@Override
	public void dao_insert(String sqlId, MemberDTO member) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.insert(sqlId,member);
		sess.commit();
		sess.clearCache();
		sess.close();
	}

	@Override
	public List<MemberDTO> dao_list(String sqlId,HashMap<String, String>hm) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberDTO>list = sess.selectList(sqlId,hm);
		sess.clearCache();
		sess.close();
		return list;
	}

	@Override
	public MemberDTO dao_findById(String sqlId, String id) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		MemberDTO dto = sess.selectOne(sqlId,id);
		sess.clearCache();
		sess.close();
		return dto;
	}

	@Override
	public void dao_update(String sqlId, MemberDTO member) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.update(sqlId, member);
		sess.commit();
		sess.clearCache();
		sess.close();
	}

	@Override
	public void dao_delete(String sqlId, String id) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.delete(sqlId, id);
		sess.commit();
		sess.clearCache();
		sess.close();	
	}

}
