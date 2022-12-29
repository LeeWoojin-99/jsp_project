package com.woojin.myapp.service;

import java.util.List;

import com.woojin.myapp.domain.BoardDTO;
import com.woojin.myapp.domain.BoardVO;

public interface BoardService {

	int insert(BoardVO bvo);

	List<BoardVO> list();

	BoardVO selectOne(int bno);

	int update(BoardVO bvo);

	int delete(int bno);

	int insert(BoardDTO bdto);

	int update(BoardDTO bdto);

}
