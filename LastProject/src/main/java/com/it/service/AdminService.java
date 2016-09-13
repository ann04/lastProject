package com.it.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.it.model.MovieVO;
import com.it.persistence.AdminDAOimpl;

@Service
public class AdminService {
	
	@Inject
	AdminDAOimpl dao;
	
	public void movieInsert(MovieVO vo) throws Exception{
		dao.movieInsert(vo);
	}
}
