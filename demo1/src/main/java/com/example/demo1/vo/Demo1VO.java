package com.example.demo1.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter						// getter 설정
@AllArgsConstructor			// 모든 변수들에 생성자( getter로 setter 만듦.)
@NoArgsConstructor
public class Demo1VO {
	
	@JsonProperty			// Json형태로 리턴을 해달라
	private int deptno;
	@JsonProperty
	private String dname;
	@JsonProperty
	private String loc;
}
