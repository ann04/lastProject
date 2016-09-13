package com.it.persistence;

import com.it.model.MovieVO;

public interface AdminDAO {
	public void movieInsert(MovieVO vo) throws Exception;
}
