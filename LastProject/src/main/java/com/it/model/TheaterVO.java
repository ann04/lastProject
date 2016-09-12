package com.it.model;

public class TheaterVO {
	private int tid;
	private String position;
	private String tname;
	
	public int getTid() {
		return tid;
	}
	public String getPosition() {
		return position == null ? "" : position.trim();
	}
	public String getTname() {
		return tname == null ? "" : tname.trim();
	}
	
	public void setTid(int tid) {
		this.tid = tid;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	
	
}
