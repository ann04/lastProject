package com.it.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SeatCheck {
	private int mid;
	private int cid;
	private int perCnt;
	private String viewdate;
	private List<String> snums;
	

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getPerCnt() {
		return perCnt;
	}
	public void setPerCnt(int perCnt) {
		this.perCnt = perCnt;
	}
	public List<String> getSnums() {
		return snums;
	}
	public void setSnums(List<String> snums) {
		this.snums = snums;
	}
	public String getViewDate() {
		return viewdate == null ? "" : viewdate.trim();
	}
	public void setViewDate(String viewdate) {
		this.viewdate = viewdate;
	}
	public HashMap<Integer,String> getSeat(){
		String snum="";
		int cnt=0, totCnt=-1;
		for(int i=0; i<snums.size(); i++){
			if(i==snums.size()){
				snum += snums.get(i);
			}else{
				snum += snums.get(i)+"/";
			} 
		}
		String[] snumA =snum.split("/");
		Arrays.sort(snumA, String.CASE_INSENSITIVE_ORDER);
		
		int[] snumArr = new int[snumA.length];
		snumArr[0]=300;
		if(snums.size()!=0){
			for(int i=0; i<snumArr.length; i++){
				snumArr[i] = Integer.parseInt(snumA[i]);
				
			}
		}
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		for(int i=0; i<240; i++){
			if(snumArr.length==0){
				hm.put(i, "бр");
				break;
			}else{
				for(int j=cnt; j<snumA.length;){
					if(snumArr[j]==i){
						hm.put(i,"бс");
						cnt++;
					}else{
						hm.put(i, "бр");
					}
					++totCnt;
					break;
				}
				if(totCnt<i){
					hm.put(i, "бр");
				}
			}
		}
		return hm;
	}
}
