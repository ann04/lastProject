<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnZip").click(function(){
		window.open("zipCheck.jsp","","width=700 height=500 scrollbars=yes");
	});
});
</script>
</head>
<body>
<form action="insert.iba" method="post" >
	<table border=1>
		<tr>
			<td colspan="2"> 주소록 등록하기 </td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>우편번호</td>
			<td><input type="text" name="zipcode" id="zipcode">
				<input type="button" value="검색" id="btnZip"></td>
		<tr>
			<td>주소</td>
			<td><input type="text" name="addr" id="addr"></td>
		</tr>
		<tr>
			<td>전화번호</td>	
			<td><input type="text" name="tel"></td>
		</tr>	
		<tr>
			<td colspan="2">
				<input type="submit" value="등록">
				<input type="reset" value="취소"></td>
		</tr>
	</table>
</form>
</body>
</html>