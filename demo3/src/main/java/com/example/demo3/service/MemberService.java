package com.example.demo3.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo3.model.Member;
import com.example.demo3.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	// 추가하기
	@Transactional
	public void save(Member member) {
		memberRepository.save(member);
	}
	
	// 페이징 없는 전체 리스트
	@Transactional
	public List<Member>list(){
		return memberRepository.findAll();
	}
	
	// 페이징 처리 전체 리스트
	@Transactional
	public Page<Member>mlist(Pageable pageable){
		return memberRepository.findAll(pageable);
	}
	
	// 상세보기
	@Transactional
	public Member view(Long id) {
		// id에 따라 조회한 값을 리턴
		return memberRepository.findById(id)
				// 값이 없다면?
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패");
		});
		/*return memberRepository.getOne(id);*/
	}
	
	// 삭제하기
	@Transactional
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	// 수정하기
	@Transactional
	public void update(Member mem) {
		// 먼저 클라이언트 측에서 받아온 Member형 매개변수를 이용하여, 특정 id를 뽑아내서 해당 정보를 상세보기
		// 상세보기가 된 정보를 Member형에 다시 담는다.
		Member mm = memberRepository.findById(mem.getId())
		.orElseThrow(()->{
			return new IllegalArgumentException("아이디없음");
		});
		// 그리고 Member형에서 클라이언트측의 정보가 담긴 Member형 매개변수의 정보를 받아서 다시 세팅
		mm.setAddr(mem.getAddr());
		mm.setName(mem.getName());
	}
	
}
