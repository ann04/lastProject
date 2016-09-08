<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnZip").click(function(){
		window.open("zipCheck.jsp","","width=700 height=500 scrollbars=yes");
	});
});

function del(num){
	if(confirm("정말 삭제할까요?")){
		location.href="delete.iba?num="+num;
	}
	
}
</script>
<body>

<form action="update.iba">
<input type="hidden" name="num" value=${dto.num}>

<table width="400px" border="solid" align="center">
<tr>
	<td>번호</td>
	<td><input type="text" value="${dto.num}"></td>	
</tr>
<tr>	
	<td>이름</td>
	<td><input type="text" value="${dto.name}"></td>	
</tr>
<tr>
	<td>우편번호</td>
	<td><input type ="text" name="zipcode" id="zipcode" value="${dto.zipcode}">
	<input type="button" value="찿기 " id="btnZip"></td>
</tr>	
<tr>
	<td>주소</td>
	<td><input type ="text" name="addr" id="addr" value="${dto.addr}"></td>	
</tr>
<tr>
	<td>전화번호</td>
	<td><input type ="text" name="tel" id="tel" value="${dto.tel}"></td>	
</tr>
<tr>
	<td colspan="2">
	<input type="submit" value="수정">
	<input type="button" value="삭제" onclick="del(${dto.num})">
	</td>
</tr>
</table>
</form>		
</body>
</html>