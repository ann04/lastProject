package com.it.myapp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.it.model.AllJoinVO;
import com.it.model.MemberVO;
import com.it.model.ZipCodeVO;
import com.it.service.MemberService;

@Controller("movie/join/*")
@SessionAttributes("loginsession")
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
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(Model model,String id,String password) throws Exception{
		HashMap<String, String> hm= new HashMap<String, String>();
		hm.put("id", id);
		hm.put("password", password);
		String id1=service.usercheck(hm);
		
		if(id1==null){
			model.addAttribute("msg","id/pw 오류");
		}else{
			model.addAttribute("loginsession",id1);
		}
		return "/movie/login";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(SessionStatus session) throws Exception{
		session.setComplete();
		return "redirect:/";
		
	}
	
	@RequestMapping(value="myPage", method=RequestMethod.GET)
	public String mypage() throws Exception{
		return "/movie/join/myPage";
	}
	
	@RequestMapping(value="passCheckform", method=RequestMethod.GET)
	public String passCheckform() throws Exception{
		return "/movie/join/passCheck";
	}
	
	@RequestMapping(value="passcheck", method=RequestMethod.POST)
	public String passCheck(Model model,String id, String password) throws Exception{
		HashMap<String, String> hm=new HashMap<String, String>();
		hm.put("id", id);
		hm.put("password", password);
		MemberVO vo=service.passcheck(hm);
		
		if(vo==null){
			model.addAttribute("msg", "pw 오류");
			return "/movie/passMsg";
		}else{
			model.addAttribute("uInfo", vo);
			return "/movie/join/memberUpdate";
		}
	}
	
	@RequestMapping(value="userupdate", method=RequestMethod.POST)
	public String memupdate(Model model,MemberVO vo) throws Exception{
		service.update(vo);
		return "/movie/main";
	}
	
	@RequestMapping(value="memberdel", method=RequestMethod.GET)
	public String memdelete(String id, SessionStatus session) throws Exception{
		service.delete(id);
		session.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="reservecheck", method=RequestMethod.GET)
	public String reserveCheck(Model model,String userId) throws Exception{
		List<AllJoinVO> avo = service.reserveCheck(userId);
		HashMap<AllJoinVO,Integer> hm = new HashMap<AllJoinVO,Integer>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm");
		String dt = sdf.format(date);
		date = sdf.parse(dt);
		
		for(int i=0; i<avo.size();i++){
			Date viewdate = sdf.parse(avo.get(i).getViewdate());
			if(date.compareTo(viewdate)>0){
				hm.put(avo.get(i), 1);
			}else{
				hm.put(avo.get(i), 0);
			}
		}
		model.addAttribute("res",hm);
		return "/movie/join/reserveInfo";
	}
}
