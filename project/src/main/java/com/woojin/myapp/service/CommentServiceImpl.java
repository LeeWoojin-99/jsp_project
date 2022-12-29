package com.woojin.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.woojin.myapp.domain.CommentVO;
import com.woojin.myapp.repository.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {
	@Inject
	private CommentDAO cdao;

	@Override
	public int insert(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.insert(cvo);
	}

	@Override
	public List<CommentVO> list(int bno) {
		// TODO Auto-generated method stub
		return cdao.list(bno);
	}

	@Override
	public int update(CommentVO cvo) {
		// TODO Auto-generated method stub
		return cdao.update(cvo);
	}

	@Override
	public int delete(int cno) {
		// TODO Auto-generated method stub
		return cdao.delete(cno);
	}

}
