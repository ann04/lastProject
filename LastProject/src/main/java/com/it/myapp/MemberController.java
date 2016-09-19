package com.it.myapp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.model.MemberVO;
import com.it.model.ZipCodeVO;
import com.it.service.MemberService;

@Controller("movie/join/*")
public class MemberController {
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="joinform", method=RequestMethod.GET)
	public String joinform(){
		return "/movie/join/JoinForm";
	}
	
	@RequestMapping(value="zipCheckform", method=RequestMethod.GET)
	public String zipCheckform(){
		
		return "/movie/join/zipCheck";
	}
	
	@RequestMapping(value="zipSearch", method=RequestMethod.GET)
	public String zipSerch(Model model,String dong) throws Exception{
		List<ZipCodeVO> zipCode=service.zipSearch(dong);
		model.addAttribute("ziplists", zipCode);
		return "/movie/join/zipResult";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(MemberVO vo) throws Exception{
		service.insert(vo);
		return "/movie/main";
	}
}
