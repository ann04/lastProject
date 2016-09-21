package com.it.persistence;

import java.util.HashMap;
import java.util.List;

import com.it.model.CinemaVO;
import com.it.model.MovieVO;
import com.it.model.TheaterVO;

public interface AdminDAO {
	public void movieInsert(String id,MovieVO vo, int cid) throws Exception;
	public String adminLogin(String id,HashMap<String,String> hm) throws Exception;
	public List<MovieVO> movieAll(String id);
	public List<TheaterVO> thea(String id);
	public List<CinemaVO> cinemaView(String id, int tid);
	public int allCount(String id);
	public List<Integer> theaCount(String id);
	public List<Integer> movCount(String id);
}
