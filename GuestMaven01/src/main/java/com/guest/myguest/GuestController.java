package com.guest.myguest;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guest.model.GuestService;
import com.guest.util.PageAction;
import com.guest.vo.GuestVO;

@Controller
public class GuestController {
	
	@Autowired
	private GuestService service;
	
	@Autowired
	private PageAction page;
	
	
	@GetMapping("gInsert")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("gInsert")
	public String insert(HttpServletRequest req, GuestVO guest) {
		guest.setIpaddr(req.getRemoteAddr());
		service.insert(guest);
		return "redirect:gList";
		// 추가하면서 리스트화면도 바로 뿌려주기
	}
	
	@GetMapping("gList")
	public String list(Model mv,String pageNum,
			String field,
			String word
			) {
		// 검색기능을 위해서 해쉬맵 사용. 여기선 value가 String형
		HashMap<String, Object> hm = new HashMap<>(); 
		hm.put("field", field);
		hm.put("word", word);
		// 페이징 처리를 위한 변수 저장.
		int count = service.count(hm);	// 전체 개수
		int pageSize = 5;				// 한 화면에 보여지는 수
		if(pageNum==null) pageNum="1";	// 페이지넘버가 없다면 1을 저장
		int currentPage = Integer.parseInt(pageNum);	// 현재 페이지 저장.
		int startRow = (currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;
		if(endRow>count) endRow=count;
		// 해쉬맵을 사용. value는 int형
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		// 페이징 처리를 위한 함수를 따로 만들어서 사용. [이전]456[다음] 이것을 담음.
		String pageHtml = page.paging(count,pageSize,currentPage,field,word);
		
		List<GuestVO> list = service.list(hm);
		mv.addAttribute("count",count);
		mv.addAttribute("pageHtml",pageHtml);
		mv.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping(value = "gView",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String view(
			@RequestParam(value = "num") int num) {
		// GuestVO를 돌려주고 싶다. 하지만 받는 자바스크립트에서 알아서 데이터들을 나눌수 없다.
		GuestVO vo = service.findById(num);
		// JSON객체를 만들어서 VO 데이터들을 각각 넣어준다.
		JSONObject jobj = new JSONObject();
		jobj.put("writter", vo.getWritter());
		jobj.put("content", vo.getContent());
		jobj.put("grade", vo.getGrade());
		jobj.put("created", vo.getCreated());
		jobj.put("ipaddr", vo.getIpaddr());
		// @ResponseBody를 통해서 문자열 그대로를 반환시킨다.
		return jobj.toString();
	}
	
	@GetMapping("gdelete")
	public String delete(int num) {
		
		service.delete(num);
		
		return null;
		
	}
	
}
