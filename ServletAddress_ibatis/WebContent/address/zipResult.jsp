<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
<c:forEach items="${ziplists}" var="zip">
		<tr>
		   <td >${zip.zipcode}</td> 
		   <td>${zip.sido}</td>
		   <td>${zip.gugun}</td>
		   <td>${zip.dong}</td>
		   <td>${zip.bunji}</td>
		 </tr>
</c:forEach>
</table>

