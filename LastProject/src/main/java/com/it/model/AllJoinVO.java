package com.it.model;

public class AllJoinVO {
	private int rnum;
	private int mid;
	private String snum;
	private int cid;
	private String viewdate;
	private String id;
	private String title;
	private String tname;
	private String cname;
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getSnum() {
		return snum == null ? "" : snum.trim();
	}
	public void setSnum(String snum) {
		this.snum = snum;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getViewdate() {
		return viewdate == null ? "" : viewdate.trim();
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
	public String getTitle() {
		return title == null ? "" : title.trim();
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTname() {
		return tname == null ? "" : tname.trim();
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getCname() {
		return cname == null ? "" : cname.trim();
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
