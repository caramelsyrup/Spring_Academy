package com.myandroid.mypro;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myandroid.model.AppUserServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private AppUserServiceImpl service;
	
	/*
	 * @RequestMapping(value = "/", method = RequestMethod.GET) public String
	 * home(Model model) { return "login"; }
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,Object> login(Model model,String userID,String password) {
		Map<String,Object> result = new HashMap<String,Object>();
		int sign = service.login(userID, password);
		result.put("sign", sign);
		return result;
	}
	
	
}
