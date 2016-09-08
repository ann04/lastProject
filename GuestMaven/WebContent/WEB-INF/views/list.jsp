<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="right">총게수물 수:${count}</div>
<table border=1 align="center" style="font-family:맑은 고딕;font-size:10pt">
		<tr style="background-color: #c8c8c8">
			<th>번호</th>
			<th>이름</th>
			<th>내용</th>
			<th>평가</th>
			<th>날짜</th>
			<th>IP주소</th>
			<c:if test="${loginSession!=null}">
				<th>삭제</th>
			</c:if>
		</tr>
	<c:forEach items="${lists}" var="list">
		<tr>
			<td>${list.num}</td>
			<td><a href="javascript:view(${list.num})">${list.name}</a></td>
			<td>${list.content}</td>
			<td>${list.grade}</td>
			<td>${list.created}</td>
			<td>${list.ipaddr}</td>
			<c:if test="${loginSession!=null}">
				<td><a href="javascript:del(${list.num})">삭제</a></td>
			</c:if>
		</tr>
	</c:forEach>
</table>

<div align="center">
	${pageHtml}
</div>