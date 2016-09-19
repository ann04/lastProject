package com.it.persistence;

import java.util.HashMap;
import java.util.List;

import com.it.model.MovieVO;
import com.it.model.TheaterVO;

public interface AdminDAO {
	public void movieInsert(MovieVO vo) throws Exception;
	public String adminLogin(String id,HashMap<String,String> hm) throws Exception;
	public List<MovieVO> movieAll(String id);
	public List<TheaterVO> thea(String id);
}
