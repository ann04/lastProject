package com.it.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.it.model.MovieVO;
import com.it.model.TheaterVO;
@Repository
public interface MovieDAO {
	public List<MovieVO> movieAll(String id);
	public List<TheaterVO> theaterAll(String id);
}
