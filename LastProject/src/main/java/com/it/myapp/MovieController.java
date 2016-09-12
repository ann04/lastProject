package com.it.myapp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.model.MovieVO;
import com.it.model.TheaterVO;
import com.it.service.MovieService;
@Controller("movie/*")
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
	
}
