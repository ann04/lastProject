package com.it.persistence;

import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.it.model.AllJoinVO;
import com.it.model.MemberVO;
import com.it.model.ReservationVO;
import com.it.model.ZipCodeVO;
@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession session;
	
	@Override
	public List<ZipCodeVO> zipSearch(String id,String dong) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(id,dong);
	}

	@Override
	public void insert(String id, MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(id,vo);
	}

	@Override
	public String usercheck(String id, HashMap<String, String> hm) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(id,hm);
	}

	@Override
	public MemberVO passcheck(String id, HashMap<String, String> hm) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(id,hm);
	}

	@Override
	public void update(String id, MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(id,vo);
	}

	@Override
	public void delete(String id,String userid) throws Exception {
		// TODO Auto-generated method stub
		session.delete(id,userid);
	}

	@Override
	public List<AllJoinVO> reserveCheck(String id, String userId) throws Exception {
		return session.selectList(id,userId);
	}
	
}
