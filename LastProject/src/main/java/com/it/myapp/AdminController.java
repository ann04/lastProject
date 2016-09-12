package com.it.myapp;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.it.model.MovieVO;
import com.it.service.AdminService;

@Controller("admin/*")
public class AdminController {
	
	@Inject
	AdminService service;
	
	@RequestMapping(value="movieinsert", method=RequestMethod.POST)
	public String movieInsert(MovieVO vo) throws Exception{
		service.movieInsert(vo);
		return "/amdin/adminmain";
	}
	
}
