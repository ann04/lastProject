package org.zerock.domain;




public class Criteria {
	private int page;
	private int perPageNum;
	private int startRow;
	private int endRow;
	
/*	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}*/
	public Criteria(){
		this.page=1;
		this.perPageNum=5;
	}
	
	public int getStartRow() {
		startRow = (page-1)*perPageNum+1;
		return startRow ;
	}
	
	public int getEndRow(){
		endRow = page*perPageNum;
		return endRow ;
	}
	public void setPage(int page) {
		if(page<=0){
			this.page = 1;
			return;
		}
		this.page=page;
		
	}
	
	public void setPerPageNum(int perPageNum) {
		if(perPageNum<=0||perPageNum>100){
			this.perPageNum=10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	public int getPage() {
		return page;
	}
	
	public int getPageStart(){
		return (this.page-1)*perPageNum;
	}
	
	public int getPerPageNum(){
		return this.perPageNum;
	}
	
	public String toString(){
		return "Criteria [page="+page+","+"perPageNum="+perPageNum+"]";
	}
	
}
