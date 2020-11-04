package com.example.demo1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo1.service.Demo1Service;
import com.example.demo1.vo.Demo1VO;

@Controller
public class Demo1Controller {
	// @Autowired 
	private Demo1Service deptService;

	// 어노테이션을 쓰지 않고, 생성자를 이용해서 사용. 현장에서 바로 변경사항 적용을 위해서
	public Demo1Controller(Demo1Service demo1Service) {
		this.deptService = demo1Service;
	}
	@GetMapping("/")
	public String index() {
		return "home";
	}
	@GetMapping("list")
	@ResponseBody
	public List<Demo1VO> list(){
		return deptService.list();
	}
	

}
