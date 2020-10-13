package com.member.mytest;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.member.model.MemberDAO;
import com.member.model.MemberDTO;
import com.member.model.MemberServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private MemberServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@GetMapping(value = "list")
	public String list(Model mv) {
		List<MemberDTO>list = service.list();
		mv.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping(value = "insert")
	public String insert() {
		return "insertForm";
	}
	
	@PostMapping(value = "insert")
	public String insert(MemberDTO member) {
		service.insert(member);
		return "redirect:list";
	}
	
	@GetMapping(value = "view")
	public String findById(String id,Model mv) {
		
		MemberDTO dto = service.findById(id);
		mv.addAttribute("user", dto);
		return "view";
	}
	
	@GetMapping(value = "update" )
	public String update(String id,Model mv) {
		
		MemberDTO dto = service.findById(id);
		mv.addAttribute("user", dto);
		return "updateForm";
	}
	
	@PostMapping(value = "update")
	public String update(MemberDTO member) {
		service.update(member);
		return "redirect:list";
	}
	
	@GetMapping(value = "delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:list";
		
	}
	
}
