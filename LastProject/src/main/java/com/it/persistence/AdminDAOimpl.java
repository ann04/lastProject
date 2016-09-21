package com.it.persistence;



import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.it.model.CinemaVO;
import com.it.model.MovieVO;
import com.it.model.TheaterVO;



@Repository
public class AdminDAOimpl implements AdminDAO{
	@Inject
	private SqlSession session;
	
	@Override
	public void movieInsert(String id,MovieVO vo, int cid) throws Exception {
		session.insert(id, vo);
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("cid", cid);
		hm.put("mid", session.selectOne("movMid",vo.getImg()));
		session.insert("mov_cid",hm);
	}

	@Override
	public String adminLogin(String id,HashMap<String, String> hm) throws Exception {
		return session.selectOne(id, hm);
	}

	@Override
	public List<MovieVO> movieAll(String id) {
		return session.selectList(id);
	}

	@Override
	public List<TheaterVO> thea(String id) {
		return session.selectList(id);
	}
	@Override
	public List<CinemaVO> cinemaView(String id, int tid) {
		return session.selectList(id,tid);
	}

	@Override
	public int allCount(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Integer> theaCount(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Integer> movCount(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
