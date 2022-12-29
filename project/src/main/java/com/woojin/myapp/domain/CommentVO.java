package com.woojin.myapp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class CommentVO {
	private int bno;
	private int cno;
	private String writer;
	private String content;
	private String reg_date;
	private String mod_date;

}
