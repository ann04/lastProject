package com.it.service;

import org.springframework.stereotype.Component;

@Component
public class pageAction {
	public String paging(int count, int pageSize, int currentPage,int mid){
		int totPage=(count/pageSize)+(count%pageSize==0?0:1);//총 패이지 수
		int blockpage=3;//보여지는 페이지
		
		int startPage=((currentPage-1)/blockpage)*blockpage+1;
		int endPage=startPage+blockpage-1;
		if(endPage>totPage) endPage=totPage;
		
		StringBuffer sb=new StringBuffer();
		if(count>0){//게시물이 있다면
			if(startPage>blockpage){//시작페이지가 3보다 크면
				sb.append("<a href='javascript:getData(");
	    		sb.append(startPage-blockpage+")'");//4-3
	    		
	    		sb.append("'>[이전]</a>");
			}
			for(int i=startPage; i<=endPage; i++){
				if(i==currentPage){
					sb.append("["+i+"]");
				}else{
					sb.append("<a href='javascript:getData(");
		    		sb.append(i+")'");
		    		
		    		sb.append("'>["+i+"]</a>");
				}
			}
			if(endPage<totPage){ //다음
	    		  sb.append("<a href='javascript:getData(");
	    		  sb.append(startPage+blockpage+")'");//7(4+3),8(5+3),9(6+3)
	    		
	    		  sb.append("'>[다음]</a>");
	    	  }
		}
		
		return sb.toString();
	}
}
