package com.member.mytest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sun.tools.sjavac.Log;

@Controller
@RequestMapping("/sample/")
public class SampleController {
	@RequestMapping("/")
	public void basic() {
		Log.info("basic...");
	}
}
