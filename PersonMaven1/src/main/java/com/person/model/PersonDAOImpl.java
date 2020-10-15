package com.person.model;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {
	
	@Autowired
	private SqlSessionFactory sqlMapper;
	
	
	@Override
	public List<PersonDTO> dao_list(String sqlId,HashMap<String, String>hm) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		List<PersonDTO> list = sess.selectList(sqlId,hm);
		sess.clearCache();
		sess.close();
		return list;
	}

	@Override
	public PersonDTO dao_view(String sqlId, String id) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		PersonDTO person = sess.selectOne(sqlId,id);
		sess.commit();
		sess.clearCache();
		sess.close();
		return person;
	}

	@Override
	public void dao_insert(String sqlId, PersonDTO person) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.insert(sqlId,person);
		sess.commit();
		sess.clearCache();
		sess.close();
		
	}

	@Override
	public void dao_update(String sqlId, PersonDTO person) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.update(sqlId,person);
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

	@Override
	public String dao_countPerson(String sqlId) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		String result = sess.selectOne(sqlId);
		sess.clearCache();
		sess.close();
		return result;
	}

}
