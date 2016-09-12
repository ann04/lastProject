package com.it.model;

public class MCJoinVO {
	private int cid;
	private int tid;
	private String cname;
	private int seatcnt;
	private int mid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getCname() {
		return cname == null ? "" : cname.trim();
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getSeatcnt() {
		return seatcnt;
	}
	public void setSeatcnt(int seatcnt) {
		this.seatcnt = seatcnt;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	
}
