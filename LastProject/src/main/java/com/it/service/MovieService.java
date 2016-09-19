package com.it.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.it.model.MCJoinVO;
import com.it.model.MovieVO;
<<<<<<< HEAD
import com.it.model.ReplyVO;
=======
import com.it.model.SeatCheck;
>>>>>>> branch 'master' of https://github.com/ann04/lastProject.git
import com.it.model.TheaterVO;
import com.it.persistence.MovieDAO;

@Service
public class MovieService {
	@Inject
	private MovieDAO dao;
	
	public List<MovieVO> movieAll(){
		return dao.movieAll("mAll");
	}
	public List<TheaterVO> theaterAll(){
		return dao.theaterAll("tAll");
	}
	public List<TheaterVO> theaterView(int mid){
		return dao.theaterView("tView",mid);
	}
	public List<MCJoinVO> reserveDate(HashMap<String, Integer> hm){
		return dao.reserveDate("cinData", hm);
	}
	public MovieVO movieView(int mid){
		return dao.movieView("movView", mid);
	}
<<<<<<< HEAD
	public void insertreply(ReplyVO vo){
		dao.insertreply(vo);
	}
	public int getCount(int mid) throws Exception {
		// TODO Auto-generated method stub
		return dao.getCount(mid);
	}

	public List<ReplyVO> listreply(HashMap<String,Object> hm) throws Exception {
		// TODO Auto-generated method stub
		return dao.listreply(hm);
=======
	public List<String> getSnum(SeatCheck sc){
		return dao.getSnum("snumData",sc);
>>>>>>> branch 'master' of https://github.com/ann04/lastProject.git
	}
}
