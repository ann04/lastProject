<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select onchange='cidSend(this.value)'>
	<option value='0'>선택하세요</option>
	<c:forEach var="c" items="${cin}">
		<option value="${c.cid}">c.cname</option>
	</c:forEach>
</select>
						