package com.woojin.myapp.service;

import java.util.List;

import com.woojin.myapp.domain.CommentVO;

public interface CommentService {

	int insert(CommentVO cvo);

	List<CommentVO> list(int bno);

	int update(CommentVO cvo);

	int delete(int cno);

}
