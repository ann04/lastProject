<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="admin" method="post">
	<p>방명록 주인장만 사용할 수 있는 페이지 입니다.</p>
	<p><a href="insert.jsp">[홈으로 돌아가기]</a></p>
	<table>
		<tr valign="middle">
			<td><b>ID</b></td>
			<td><input type="text" name="uid"></td>
		</tr>
		<tr>
			<td><b>PW</b></td>
			<td><input type=password name="upw"></td>
		</tr>
		<tr>
		<td colspan="2">
			<input type="submit" value="로그인">
			<span style="color:red">${errMsg}</span>
		</td>
	</tr>
	</table>
</form>
</body>
</html>