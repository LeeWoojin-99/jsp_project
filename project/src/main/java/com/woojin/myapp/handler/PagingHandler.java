package com.woojin.myapp.handler;

import com.woojin.myapp.domain.PagingVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class PagingHandler {
	private int endPage;
	private int startPage;
	private boolean prev, next;
	private int totalEndPage;
	private PagingVO pvo;
	
	public PagingHandler(PagingVO pvo, int totalCount){
		this.pvo = pvo;
		this.endPage = (int) Math.ceil(pvo.getPageNo() /(pvo.getQty()*1.0)) *pvo.getQty();
		this.startPage = this.endPage - (pvo.getQty() -1);
		
		this.totalEndPage = (int) Math.ceil(totalCount/ (pvo.getQty()*1.0));
		if(this.totalEndPage < this.endPage) this.endPage = this.totalEndPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < this.totalEndPage;
	}
}
