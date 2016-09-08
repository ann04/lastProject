package com.myspring.domain;
 
public class GuestVO {
	private int num;  
	private String name;
	private String content;
	private String grade;
	private String created;
	private String ipaddr;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name == null ? "" : name.trim();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content == null ? "" : content.trim();
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getGrade() {
		return grade == null ? "" : grade.trim();
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCreated() {
		return created == null ? "" : created.trim();
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getIpaddr() {
		return ipaddr == null ? "" : ipaddr.trim();
	}
	public void setIpaddr(String ipaddr) {
		this.ipaddr = ipaddr;
	}
	
	
}
