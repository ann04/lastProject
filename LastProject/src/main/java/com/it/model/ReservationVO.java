package com.it.model;

public class ReservationVO {
	private int rnum;
	private int mid;
	private String snum;
	private int cid;
	private String viewdate;
	private String id;
	public int getRnum() {
		return rnum;
	}
	public int getMid() {
		return mid;
	}
	public String getSnum() {
		return snum == null ? "" : snum.trim();
	}
	public int getCid() {
		return cid;
	}
	public String getViewdate() {
		return viewdate == null ? "" : viewdate.trim();
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public void setViewdate(String viewdate) {
		this.viewdate = viewdate;
	}
	public String getId() {
		return id == null ? "" : id.trim();
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
