package com.myspring.persistence;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.myspring.domain.GuestVO;
@Repository
public class GuestDAOImpl implements GuestDAO{
	@Inject
	private SqlSession session;
	
	@Override
	public void insert(String id, GuestVO gb) {
		session.insert(id,gb);
	}

	@Override
	public void delete(String id, Object value) {
		session.delete(id,value);
	}

	@Override
	public GuestVO findById(String id, Object value) {
		
		return session.selectOne(id,value);
	}

	@Override
	public void update(String id, GuestVO gv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCount(String id,HashMap<String, Object> hm) {
		return session.selectOne(id,hm);
	}

	@Override
	public List getList(String id, HashMap<String, Object> hm) {
		return session.selectList(id,hm);
	}

	

}
