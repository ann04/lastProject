package com.it.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
	};
	public List<TheaterVO> theaterView(int mid){
		return dao.theaterView("tView",mid);
	};
}
