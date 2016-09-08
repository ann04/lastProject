package com.myspring.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.myspring.domain.GuestVO;
import com.myspring.persistence.GuestDAO;

@Service
public class GuestService {
	@Inject
	private GuestDAO guestDAO;
	
	public List getList(HashMap<String, Object> hm) {
		return guestDAO.getList("listData",hm);
	}
	
	public int getCount(HashMap<String, Object> hm){
		return guestDAO.getCount("countData",hm);
	}
	
	public void insert(GuestVO vo){
		guestDAO.insert("insertData", vo);
	}
	
	public void delete(int num){
		guestDAO.delete("deleteData", num);
	}
	
	public GuestVO findById(Object value) {
		return guestDAO.findById("getData", value);
	}

	public void update(GuestVO gv) {
		
	}
}
