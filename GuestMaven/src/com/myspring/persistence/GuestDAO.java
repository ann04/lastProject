package com.myspring.persistence;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.myspring.domain.GuestVO;

public interface GuestDAO {
	public List getList(String id,HashMap<String, Object> hm);
	public void insert(String id, GuestVO gb);
	public void delete(String id, Object value);
	public GuestVO findById(String id, Object value);
	public void update(String id, GuestVO gv);
	public int getCount(String id,HashMap<String, Object> hm);
}
