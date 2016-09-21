package com.it.model;

public class ZipCodeVO {
	private int seq;
	private String zipcode;
	private String sido;
	private String gugun;
	private String dong;
	private String bunji;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getZipcode() {
		return zipcode == null ? "" : zipcode.trim();
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getSido() {
		return sido == null ? "" : sido.trim();
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getGugun() {
		return gugun == null ? "" : gugun.trim();
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong == null ? "" : dong.trim();
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getBunji() {
		return bunji == null ? "" : bunji.trim();
	}
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}
	
	
}
