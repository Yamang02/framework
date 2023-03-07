package com.kh.mybatis.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

public class BoardDao {

	public int getBoardCount(SqlSession session) {

		return session.selectOne("boardMapper.selectBoardCount");
	}

	public List<Board> findAll(SqlSession session, PageInfo pageInfo) {
		/*
		 * mybatis에서 페이징 처리
		 * 
		 * mybatis에서는 페이징 처리를 위해 RowBounds라는 클래스를 제공해준다. RowBounds의 인스턴스를 생성할 때 offset과
		 * limit 값을 전달해서 페이징 처리를 구현한다. (offset만큼 건너뛰고 limit만큼 가져온다.)
		 * 
		 * 
		 */

		int limit = pageInfo.getListLimit();
		int offset = (pageInfo.getCurrentPage() - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);

		return session.selectList("boardMapper.selectAll", null, rowBounds);
	}

	public List<Board> findAll(SqlSession session, String writer, String title, String content) {
		Map<String, String> map = new HashMap<>();

		map.put("writer", writer);
		map.put("title", title);
		map.put("content", content);

		return session.selectList("boardMapper.selectAllByKeyWord", map);
	}

	public int getBoardCount(SqlSession session, String writer, String title, String content) {
		Map<String, String> map = new HashMap<>();

		map.put("writer", writer);
		map.put("title", title);
		map.put("content", content);

		return session.selectOne("boardMapper.selectBoardCountByKeyWord", map);
	}

}
