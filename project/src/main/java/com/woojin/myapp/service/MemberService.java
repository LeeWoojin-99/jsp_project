package com.woojin.myapp.service;

import com.woojin.myapp.domain.MemberVO;

public interface MemberService {

	int insert(MemberVO mvo);

	MemberVO selectOne(MemberVO mvo);

}
