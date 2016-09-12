package com.it.model;

public class MovieVO {
	private int mid;
	private String title;
	private String img;
	private String director;
	private String content;
	
	public int getMid() {
		return mid;
	}
	public String getTitle() {
		return title == null ? "" : title.trim();
	}
	public String getImg() {
		return img;
	}
	
	public void setMid(int mid) {
		this.mid = mid;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setImg(String img) {
		this.img=img;
	}
	public String getDirector() {
		return director == null ? "" : director.trim();
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getContent() {
		return content == null ? "" : content.trim();
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
