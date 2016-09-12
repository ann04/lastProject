package com.it.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.it.model.MCJoinVO;
import com.it.model.MovieVO;
import com.it.model.SeatCheck;
import com.it.model.TheaterVO;
@Repository
public interface MovieDAO {
	public List<MovieVO> movieAll(String id);
	public List<TheaterVO> theaterAll(String id);
	public List<TheaterVO> theaterView(String id, int mid);
	public List<MCJoinVO> reserveDate(String id, HashMap<String,Integer> hm);
	public MovieVO movieView(String id, int mid);
	public List<String> getSnum(String id, SeatCheck sc);
}
