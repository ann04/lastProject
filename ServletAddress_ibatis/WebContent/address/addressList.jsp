<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>

<script>
$(document).ready(function(){
	$("#searchBtn").click(function(){
		if($("#word").val()==""){
			alert("검색어를 입력하세요");
			return false;
		}
		$.get("search.iba",
		{"field": $("#field").val(),"word": $("#word").val()},
		function(data){
			//alert(data);
			$("#area").html(data);
			}
		);
	});
});
</script>

</head>
<body>

<h2>AddrList</h2>

<div id="area">
<a href="adressinsert.jsp">등록하기</a><br>
<div align="right">총게시물수 : ${count}</div>
<table border=1 align="center">
	<thead>
		<tr>
			<th>이름</th>
			<th>주소</th>
			<th>전화번호</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="i" items="${lists}">
			<tr>
				<td><a href="view.iba?num=${i.num}">${i.name}</a></td>
				<td>${i.addr}</td>
				<td>${i.tel}</td>
			</tr>
		</c:forEach>
	</tbody> 
</table>
</div>


<br><br>
<form id="search" align="center">
	<select id="field">
		<option value="name">이름</option>
		<option value="tel">전화번호</option>
	</select>
	<input type="text" id="word">
	<input type="button" value="검색" id="searchBtn">
</form>
</body>
</html>