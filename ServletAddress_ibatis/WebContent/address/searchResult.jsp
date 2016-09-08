<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="right"> 총 게시물수 : ${count}</div>   
 
    <table width="400px"  border="solid" align="center">
    <tr>
    	<th>이름 </th>
    	<th>주소 </th>
    	<th>전화번호 </th>
    </tr>
    
		<c:forEach var="s" items="${sarr}">
			<tr>
				<td>${s.name }</td>
				<td>${s.addr}</td>
				<td>${s.tel}</td>
			</tr>
		</c:forEach>	
	</table>