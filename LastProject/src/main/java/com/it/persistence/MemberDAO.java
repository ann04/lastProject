package com.it.persistence;

import java.util.List;

import com.it.model.MemberVO;
import com.it.model.ZipCodeVO;

public interface MemberDAO {
	public List<ZipCodeVO> zipSearch(String id,String dong) throws Exception;
	public void insert(String id, MemberVO vo) throws Exception;
}
