package com.member.model;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	// memberapp-servlet.xml에 등록된 객체 선언. mybatis를 이용. sql문의 DML 을 사용
	// SqlSessionFactory가 mybatis-spring에서 사용된다.
	@Autowired
	private SqlSessionFactory sqlMapper;
	
	@Override
	public void dao_insert(String sqlID, MemberVO member) {
		// SqlSession객체에 SqlSessionFactory의 메소드를 이용한 반환값을 저장, 기존의 트랜젝션을 계속 사용.
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		// SqlSession객체를 통해서 구체적인 sql문 실행
		sess.insert(sqlID,member);
		// 커밋
		sess.commit();
		// 닫아주기?
		sess.clearCache();
		sess.close();
	}

	@Override
	public List<MemberVO> dao_list(String sqlID) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		List<MemberVO> list = sess.selectList(sqlID);
		// 닫아주기?
		sess.clearCache();
		sess.close();
		return list;
	}

	@Override
	public MemberVO dao_view(String sqlID, String id) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		MemberVO vo  = sess.selectOne(sqlID,id);
		// 닫아주기?
		sess.clearCache();
		sess.close();
		return vo;
	}

	@Override
	public void dao_update(String sqlID, MemberVO member) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.update(sqlID,member);
		sess.commit();
		// 닫아주기?
		sess.clearCache();
		sess.close();
	}

	@Override
	public void dao_delete(String sqlID, String id) {
		SqlSession sess = sqlMapper.openSession(ExecutorType.REUSE);
		sess.delete(sqlID, id);
		sess.commit();
		// 닫아주기?
		sess.clearCache();
		sess.close();
	}

}
