package com.it.persistence;

import java.util.List;
import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.it.model.MemberVO;
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
	
	
}
