package com.it.myapp;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String reserveView(Model model){
		model.addAttribute("movie",service.movieAll());
		model.addAttribute("theater",service.movieAll());
		return "/movie/reserveView";
	}
	
}
