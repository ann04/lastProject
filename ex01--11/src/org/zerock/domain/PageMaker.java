package org.zerock.domain;

import org.springframework.stereotype.Component;

@Component
public class PageMaker {
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 3;
	
	private Criteria cri;
	
	public void setCri(Criteria cri){
		this.cri=cri;
	}
	
	public void setTotalCount(int totalCount){
		this.totalCount= totalCount;
		calcData();
	}
	
	private void calcData(){
		startPage = ((cri.getPage()-1)/displayPageNum)*displayPageNum+1;
		endPage = startPage+displayPageNum-1;
		int tempEndPage = (int) (Math.ceil(totalCount/(double)cri.getPerPageNum()));
		if(endPage>tempEndPage){
			endPage=tempEndPage;
		}
		prev=startPage==1?false:true;
		next=endPage*cri.getPerPageNum()>=totalCount?false:true;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public Criteria getCri() {
		return cri;
	}
}
