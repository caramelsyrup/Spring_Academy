package com.myguest.myapp;


import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myguest.model.GuestBookDTO;
import com.myguest.model.GuestBookServiceImpl;
import com.myguest.model.GuestListVO;
import com.myguest.model.PageAction;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private GuestBookServiceImpl service;
	
	@Autowired
	private PageAction page;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "insert";
	}
	
	// 추가하기
	@PostMapping("gInsert")
	public void insert(@ModelAttribute("gb") GuestBookDTO gb) {
		service.guestInsert(gb);
	
	}
	
	// 전체보기
	// 정보들을 담은 클래스 형으로 하는 함수를 만듦. 그래서 이 클래스의 참조변수를 반환하도록 유도.
	// @ResponseBody는 json 형태로 값을 돌려주는 어노테이션. 
	@GetMapping("glist")
	@ResponseBody
	public GuestListVO list(String pageNum,String field,String word) {
		
		HashMap<String, Object> hm  = new HashMap<>();
		hm.put("field", field);
		hm.put("word", word);
		int count = service.guestCount(hm);
		hm.put("count", count);
		
		// 한화면에 보여지는 게시물 수
		int pageSize = 5;
		if(pageNum==null) pageNum="1";
		int currentPage = Integer.parseInt(pageNum);
		
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;
		if(endRow>count) endRow = count;
		
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		List<GuestBookDTO> list = service.list(hm);
		
		String pageHtml = page.paging(count,pageSize,currentPage,field,word);
		GuestListVO listvo  = new GuestListVO(count,list,pageHtml);
		return listvo;
	}
	
	// 상세보기
	@GetMapping("gview")
	@ResponseBody
	public GuestBookDTO findById(int num) {
		GuestBookDTO dto = service.findByNum(num);
		return dto;
	}
	
	// 수정하기
	@GetMapping("gupdate")
	public void update(int num) {
		GuestBookDTO gb = service.findByNum(num);
		service.guestUpdate(gb);
	}
	// 삭제하기
	@GetMapping("gdelete")
	@ResponseBody
	public String delete(int num) {
		service.guestDelete(num);
		return "success";
	}
	
	
}
