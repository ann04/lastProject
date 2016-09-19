package com.it.myapp;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

<<<<<<< HEAD

import com.it.model.MovieVO;
import com.it.model.ReplyVO;
=======
import com.it.model.AllJoinVO;
import com.it.model.ReservationVO;
import com.it.model.SeatCheck;
>>>>>>> branch 'master' of https://github.com/ann04/lastProject.git
import com.it.model.TheaterVO;
import com.it.service.MovieService;
import com.it.service.pageAction;
@Controller
public class MovieController {
	@Inject
	private MovieService service;
	@Inject
	public pageAction page;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "/movie/main";
	}
	
	@RequestMapping(value="/reserveview", method=RequestMethod.GET)
	public String reserveView(Model model,String mid){
		String fileName="";
		List<TheaterVO> tvo = null;
		if(mid==null){
			fileName="/movie/reserveView";
			tvo = service.theaterAll();
		}else{
			fileName="/movie/theaResult";
			tvo = service.theaterView(Integer.parseInt(mid));
		}
		model.addAttribute("movie",service.movieAll());
		model.addAttribute("theater",tvo);
		return fileName;
	}
	
	@RequestMapping(value="/reservedate", method=RequestMethod.GET)
	public String reserveDate(Model model, int mid, int tid){
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("tid", tid);
		hm.put("mid", mid);
		model.addAttribute("mcJoin",service.reserveDate(hm));
		return "/movie/dateResult";
	}
	
	@RequestMapping(value="/reserveseat", method=RequestMethod.GET)
	public String reserveSeat(Model model, SeatCheck sc,int pcnt,String viewdate){
		sc.setPCnt(pcnt);
		sc.setViewDate(viewdate);
		sc.setSnums(service.getSnum(sc));
		model.addAttribute("hm",sc.getSeat());
		model.addAttribute("perCnt",sc.getPCnt());
		return "/movie/reserveSeat";
		
	}
	
	@RequestMapping(value="/reservation", method=RequestMethod.POST)
	public String reservation(String mid,String cid,String viewdate, String[] snum){
		return null;
	}
	
	@RequestMapping(value="/movieall", method=RequestMethod.GET)
	public String movieAll(Model model){
		model.addAttribute("mv",service.movieAll());
		return "/movie/movieAllView";
	}
	
	@RequestMapping(value="/movieview", method=RequestMethod.GET)
	public String movieView(Model model, int mid){
		model.addAttribute("mov",service.movieView(mid));
		return "/movie/movieView";
	}
	@RequestMapping(value="/insertreply",method=RequestMethod.GET)
	public String insertreply(ReplyVO vo){
		service.insertreply(vo);
		return "redirect:/listreply?mid="+vo.getMid();
	}
	@RequestMapping(value="/listreply",method={RequestMethod.GET, RequestMethod.POST})
	public String listreply(String pageNum,Model model,int mid)throws Exception{
	
		
		int pageSize = 5;
		if(pageNum==null){
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);//현재 페이지
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;
		int count = service.getCount(mid);//게시물 수
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		hm.put("mid", mid);
		System.out.println("count : " + count);
		System.out.println(hm);
		
		if(endRow>count) endRow =count;
		
	
		
		
		String pageHtml = page.paging(count,pageSize,currentPage,mid);
		model.addAttribute("reply",service.listreply(hm));
		model.addAttribute("count",count);
		model.addAttribute("pageHtml",pageHtml);
		
		return "/movie/board/listResult";
	}
	@RequestMapping(value="/results",method={RequestMethod.GET, RequestMethod.POST})
	public String result(String pageNum,Model model,int mid) throws Exception{

		
		int pageSize = 5;
		if(pageNum==null){
			pageNum="1";
		}
		int currentPage = Integer.parseInt(pageNum);//현재 페이지
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		int startRow=(currentPage-1)*pageSize+1;
		int endRow = startRow+pageSize-1;
		int count = service.getCount(mid);//게시물 수
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		hm.put("mid", mid);
		System.out.println("count : " + count);
		System.out.println(hm);
		
		if(endRow>count) endRow =count;
		
	
		
		
		String pageHtml = page.paging(count,pageSize,currentPage,mid);
		model.addAttribute("reply",service.listreply(hm));
		model.addAttribute("count",count);
		model.addAttribute("pageHtml",pageHtml);
		
		return "/movie/results";
	}


}



