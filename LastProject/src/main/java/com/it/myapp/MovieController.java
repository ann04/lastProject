package com.it.myapp;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.model.MovieVO;
import com.it.model.TheaterVO;
import com.it.service.MovieService;
@Controller
public class MovieController {
	@Inject
	private MovieService service;
	
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
	public String reserveSeat(Model model){
		
		return "/movie/reserveSeat";
		
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
	
}
