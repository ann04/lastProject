package com.it.persistence;



import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.it.model.MovieVO;
import com.it.model.TheaterVO;



@Repository
public class AdminDAOimpl implements AdminDAO{
	@Inject
	private SqlSession session;
	
	@Override
	public void movieInsert(MovieVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert("insertData", vo);
		session.commit();
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

}
