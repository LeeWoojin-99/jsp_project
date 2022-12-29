package com.woojin.myapp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class MemberVO {
	private String id;
	private String pw;
	private String nick_name;
	private String reg_date;	
	private String last_login;	
}
