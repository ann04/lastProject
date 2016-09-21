package com.it.myapp;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import com.it.model.CinemaVO;
import com.it.model.MovieVO;
import com.it.model.TheaterVO;
import com.it.service.AdminService;
import com.it.service.MemberService;

@Controller("admin/*")
@SessionAttributes("adloginSession")
public class AdminController {
	@Resource(name="uploadPath")
	private String uploadPath;
	@Inject
	AdminService service;
	
	@RequestMapping(value="/movieinsert", method=RequestMethod.POST)
	public String movieInsert(MultipartFile file,MovieVO vo, int cid) throws Exception{
		String saveName=uploadFile(file.getOriginalFilename(),file.getBytes());
		vo.setImg(saveName);
		service.movieInsert(vo,cid);
		return "redirect:/adminmovieall";
	}
	public String uploadFile(String originName, byte[] fileData) throws Exception{
		UUID uid=UUID.randomUUID();
		String saveName=uid.toString()+"_"+originName;
		File target = new File(uploadPath,saveName);
		FileCopyUtils.copy(fileData, target);
		return saveName;
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
			model.addAttribute("adloginSession",aid);
		}
		return fileName;
	} 
	
	@RequestMapping(value="/adminlogout", method=RequestMethod.GET)
	public String adminLogout(SessionStatus session, Model model){
		session.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="/adminmovieall", method=RequestMethod.GET)
	public String movieAll(Model model){
		model.addAttribute("mv",service.movieAll());
		return "/admin/adminMovie";
	}
	
	@RequestMapping(value="/moviethea", method=RequestMethod.GET)
	public String thea(Model model){
		model.addAttribute("theater",service.thea());
		return "/admin/movieInsert";
	}
	
	@RequestMapping(value="/cinemaResult", method=RequestMethod.GET)
	public String cin(Model model, int tid){
		model.addAttribute("cin",service.cinemaView(tid));
		return "/admin/cinemaResult";
	}
	@RequestMapping(value="/theaterview", method=RequestMethod.GET)
	public String theaterView(Model model){
		List<TheaterVO> tvo = service.thea();
		//int totCount = service.allCount();
		//List<Integer> theaCount = service.theaCount();
		//List<Integer> movCount = service.movCount();
		return "/admin/cinemaRate";
	}
	
}
