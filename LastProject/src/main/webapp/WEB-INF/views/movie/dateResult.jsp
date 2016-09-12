<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<style>
	.mc input{
		background:#D9E5FF;
		border:0;
	}
</style>
</head>
<body>
	<span>시간선택</span>
	<c:forEach items="${mcJoin}" var="mcj">
		<div class="mc" id="${mcj.cid}">
			${mcj.cname}<br>
			<input type="button" value="9:00" onclick="dateSave(this.value)">
			<input type="button" value="12:00" onclick="dateSave(this.value)">
			<input type="button" value="15:00" onclick="dateSave(this.value)">
			<input type="button" value="18:00" onclick="dateSave(this.value)">
			<input type="button" value="21:00" onclick="dateSave(this.value)">
		</div><br>
	</c:forEach>
		
</body>
</html>