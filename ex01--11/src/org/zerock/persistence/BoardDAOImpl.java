package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Inject
	private SqlSession session;
	
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert("insertBoard",vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		session.update("viewCNT",bno);
		BoardVO vo = session.selectOne("readData",bno);
		return vo;
	}

	@Override
	public void udpate(BoardVO vo) throws Exception {
		session.update("updateData",vo);	
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete("deleteData",bno);
		
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		List<BoardVO> vo = session.selectList("listAll");
		return vo;
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		
		return null;
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList("listPage",cri);
	}

	@Override
	public int getCount() throws Exception {
		return session.selectOne("listCount");
	}

}
