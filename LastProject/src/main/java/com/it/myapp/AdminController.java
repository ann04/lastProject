package com.it.myapp;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.model.MovieVO;
import com.it.service.AdminService;
import com.it.service.MemberService;

@Controller("admin/*")
public class AdminController {
	
	@Inject
	AdminService service;
	
	@RequestMapping(value="movieinsert", method=RequestMethod.POST)
	public String movieInsert(MovieVO vo) throws Exception{
		service.movieInsert(vo);
		return "/amdin/adminmain";
	}

	@RequestMapping(value="/adminlogin", method=RequestMethod.POST)
	public String adminLogin(Model model, String id, String password) throws Exception{
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("id", id);
		hm.put("password", password);
		String aid = service.adminLogin(hm);
		String msg = "";
		String fileName = "";
		if(aid==null){
			msg = "아이디/비밀번호가 맞지 않습니다.";
			fileName="/movie/main";
			model.addAttribute("adminLogin",msg);
		}else{
			fileName="/admin/adminMain";
		}
		return fileName;
	} 
	
	@RequestMapping(value="/adminmovieall", method=RequestMethod.GET)
	public String movieAll(Model model){
		model.addAttribute("mv",service.movieAll());
		return "/admin/adminMovie";
	}
	
	@RequestMapping(value="/moviethea", method=RequestMethod.GET)
	public String thea(Model model){
		model.addAttribute("theater",service.thea());
		return "/admin/adminMovView";
	}
	
	@RequestMapping(value="/cinemaResult", method=RequestMethod.GET)
	public String cin(Model model){
		return null;
	}
	
}
