package com.it.persistence;


import java.util.HashMap;
import java.util.List;

import com.it.model.MemberVO;
import com.it.model.ZipCodeVO;

public interface MemberDAO {
	public List<ZipCodeVO> zipSearch(String id,String dong) throws Exception;
	public void insert(String id, MemberVO vo) throws Exception;
	public String usercheck(String id, HashMap<String, String> hm) throws Exception;
	public MemberVO passcheck(String id, HashMap<String, String> hm) throws Exception;
	public void update(String id, MemberVO vo) throws Exception;
	public void delete(String id,String userid) throws Exception;
}
