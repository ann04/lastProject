package com.it.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.it.model.CinemaVO;
import com.it.model.MovieVO;
import com.it.model.TheaterVO;
import com.it.persistence.AdminDAOimpl;

@Service
public class AdminService {
	
	@Inject
	AdminDAOimpl dao;
	
	public void movieInsert(MovieVO vo, int cid) throws Exception{
		dao.movieInsert("insertData",vo,cid);
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
	public List<CinemaVO> cinemaView(int tid){
		return dao.cinemaView("adcinD", tid);
	}
	public int allCount(){
		return dao.allCount("allcount");
	};
	public List<Integer> theaCount(){
		return dao.theaCount("theacount");
	};
	public List<Integer> movCount(){
		return dao.movCount("movcount");
	};
}
