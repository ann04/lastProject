package com.myspring.service;

import org.springframework.stereotype.Component;

@Component
public class PageAction {
	public String paging(int count,int pageSize,int currentPage){
		int totPage=(count/pageSize)+(count%pageSize==0?0:1);
		int blockPage=3;
		int startPage =((currentPage-1)/blockPage)*blockPage+1;
		int endPage = startPage+blockPage-1;
		if(endPage>totPage)endPage=totPage;
		
		StringBuffer sb = new StringBuffer();
		if(count>0){
			if(startPage>blockPage){//����
				sb.append("<a href='javascript:getData(");
				sb.append(startPage-blockPage);
				sb.append(")'>����</a>");
			}
			for(int i=startPage;i<=endPage;i++){
				if(i==currentPage){
					sb.append("["+i+"]");
				}else{
					sb.append("<a href='javascript:getData(");
					sb.append(i);
					sb.append(")'>["+i+"]</a>");
				}
			}
			if(endPage<totPage){//����
				sb.append("<a href='javascript:getData(");
				sb.append(startPage+blockPage);
				sb.append(")'>����</a>");
			}
		}
		return sb.toString();
	}
}
