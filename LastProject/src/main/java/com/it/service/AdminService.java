package com.it.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.it.model.MovieVO;
import com.it.model.TheaterVO;
import com.it.persistence.AdminDAOimpl;

@Service
public class AdminService {
	
	@Inject
	AdminDAOimpl dao;
	
	public void movieInsert(MovieVO vo) throws Exception{
		dao.movieInsert(vo);
	}
	
	public String adminLogin(HashMap<String, String> hm) throws Exception{
		return dao.adminLogin("adminCheck",hm);
	}
	
	public List<MovieVO> movieAll(){
		return dao.movieAll("mAll");
	}
	
	public List<TheaterVO> thea(){
		return dao.thea("adtAll");
	}
}
