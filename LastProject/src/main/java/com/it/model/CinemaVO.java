package com.it.model;

public class CinemaVO {
	private int cid;
	private int tid;
	private String cname;
	private int seatcnt;
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
}
