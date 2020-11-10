package com.hello.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hello.demo.domain.User;
import com.hello.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
	private UserRepository userrepository;
	
	// 추가하기
	@Transactional
	public void save(User user) {
		userrepository.save(user);
	}
	
	// 전체조회 페이징
	@Transactional
	public Page<User>ulist(Pageable pageable){
		return userrepository.findAll(pageable);
	}
	// 전체 숫자 구하기
	@Transactional
	public Long countUser() {
		return userrepository.count();
	}
	// 회원 삭제
	@Transactional
	public void delete(Long id) {
		userrepository.deleteById(id);
	}
	// 회원 상세보기
	@Transactional
	public User view(Long id) {
		// id에 따라 조회한 값을 리턴
		return userrepository.findById(id)
				// 값이 없다면?
				.orElseThrow(()->{
					return new IllegalArgumentException("회원 상세보기 실패");
		});
		/*return memberRepository.getOne(id);*/
	}
	
	// 수정하기
	// 엔터티매니저가 CONTEXT에 먼저 저장후 디비에 들어간다. @Transactional로 인해서.
	// 더티체킹을 함. 업데이트를 따로 만들지 않음.
	@Transactional
	public void update(User us) {
		
		User up = userrepository.findById(us.getId())
				.orElseThrow(()->{
					return new IllegalArgumentException("아이디없음");
				});
		up.setAge(us.getAge());
		up.setGender(us.getGender());
		up.setName(us.getName());
	}
}
