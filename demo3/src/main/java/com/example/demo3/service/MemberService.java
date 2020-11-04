package com.example.demo3.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo3.model.Member;
import com.example.demo3.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	public void save(Member member) {
		memberRepository.save(member);
	}
	
	public List<Member>list(){
		return memberRepository.findAll();
	}
	
	public Member view(Long id) {
		// id에 따라 조회한 값을 리턴
		return memberRepository.findById(id)
				// 값이 없다면?
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 실패");
		});
		/*return memberRepository.getOne(id);*/
	}
	
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
}
