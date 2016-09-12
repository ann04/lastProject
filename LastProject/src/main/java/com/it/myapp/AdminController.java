package com.it.myapp;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import com.it.model.MovieVO;
import com.it.service.AdminService;

@Controller("admin/*")
public class AdminController {
	
	@Inject
	AdminService service;
	
	public String movieInsert(MovieVO vo) throws Exception{
		service.movieInsert(vo);
		return "";
	}
	
}
