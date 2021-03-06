package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// controller를 어노테이션 해서 쓴다. 이전에는 쓰레드 핸들러, 컨트롤러를 상속받아서 처리했음. servlet.xml파일에서 context먼저 추가하고,
@Controller
public class TestController {
	
	// 현재 클래스에서 유저가 선택한 문자열(test.go)을 매개변수로 받아서 해당 메소드 실행.
	@RequestMapping("test.go")
	public String test() {
		// 리턴을 result를 반환.
		return "result";
	}
	
	@RequestMapping("test22.go")	// 웹에서 지정하는 경로(주소) 값
	public String test2() {
		// 리턴을 test를 반환.(실행하고자 하는 파일 명)
		return "test";
	}
	
	
}
