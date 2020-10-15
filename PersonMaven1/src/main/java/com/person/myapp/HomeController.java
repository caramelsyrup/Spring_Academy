package com.person.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.person.model.PersonDAOImpl;
import com.person.model.PersonDTO;
import com.person.model.PersonServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private PersonServiceImpl service;
	
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
	public String list(Model mv ,
			@RequestParam(value = "field",required = false) String field, 
			@RequestParam(value = "word",required = false) String word) {
		// 검색을 위해서 해쉬맵 사용
		HashMap<String, String> hm = new HashMap<String,String>();
		hm.put("field", field);
		hm.put("word", word);
		// 인원수 세기를 위해서
		String count  = service.countPerson();
		mv.addAttribute("count", count);
		List<PersonDTO> list = service.list(hm);
		mv.addAttribute("list",list);
		return "list";
	}
	
	@GetMapping(value = "insert")
	public String insert() {
		
		return "personForm";
	}
	
	@PostMapping(value = "insert")
	public String insert(PersonDTO person) {
		
		service.insert(person);
		
		return "redirect:list";
	}
	
	@GetMapping(value = "view")
	public String view(String id,Model mv) {
		
		PersonDTO person = service.view(id);
		mv.addAttribute("user", person);
		
		return "view";
	}
	
	@GetMapping(value = "update")
	public String update(String id,Model mv) {
		PersonDTO person = service.view(id);
		mv.addAttribute("user", person);
		return "updateForm";
	}
	
	@PostMapping(value = "update")
	public String update(PersonDTO id) {
		service.update(id);
		return "redirect:list";
	}
	
	@GetMapping(value = "delete")
	public String delete(String id) {
		service.delete(id);
		return "redirect:list";
		
	}
	
}
