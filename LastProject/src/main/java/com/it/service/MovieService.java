package com.it.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.it.model.MCJoinVO;
import com.it.model.MovieVO;
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
	public List<String> getSnum(HashMap<String, Object> hm){
		return dao.getSnum("snumData",hm);
	}
}
