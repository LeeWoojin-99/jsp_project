package com.woojin.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.woojin.myapp.domain.MemberVO;
import com.woojin.myapp.repository.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAO mdao;
	
	private int isOK;

	@Override
	public int insert(MemberVO mvo) {
		return mdao.insert(mvo);
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return mdao.selectOne(mvo);
	}

}
