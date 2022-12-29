package com.woojin.myapp.repository;

import com.woojin.myapp.domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);

	MemberVO selectOne(MemberVO mvo);

}
