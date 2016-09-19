package com.it.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.it.model.MemberVO;
import com.it.model.ZipCodeVO;
import com.it.persistence.MemberDAO;


@Service
public class MemberService {

	@Inject MemberDAO dao;
	
	public List<ZipCodeVO> zipSearch(String dong) throws Exception{
		return dao.zipSearch("zipView",dong);
	}
	
	public void insert(MemberVO vo) throws Exception{
		dao.insert("insert",vo);
	}
}
