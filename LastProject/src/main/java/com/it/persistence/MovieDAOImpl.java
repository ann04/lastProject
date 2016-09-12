package com.it.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.it.model.MCJoinVO;
import com.it.model.MovieVO;
import com.it.model.TheaterVO;
@Repository
public class MovieDAOImpl implements MovieDAO{
	
	@Inject
	private SqlSession session;
	
	@Override
	public List<MovieVO> movieAll(String id) {
		return session.selectList(id);
	}

	@Override
	public List<TheaterVO> theaterAll(String id) {
		return session.selectList(id);
	}

	@Override
	public List<TheaterVO> theaterView(String id, int mid) {
		return session.selectList(id,mid);
	}

	@Override
	public List<MCJoinVO> reserveDate(String id, HashMap<String, Integer> hm) {
		return session.selectList(id,hm);
	}

	@Override
	public MovieVO movieView(String id, int mid) {
		return session.selectOne(id,mid);
	}

	@Override
	public List<String> getSnum(String id, HashMap<String, Object> hm) {
		return session.selectList(id,hm);
	}

}
