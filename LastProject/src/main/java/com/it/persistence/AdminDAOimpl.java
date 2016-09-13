package com.it.persistence;



import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.it.model.MovieVO;



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

}
