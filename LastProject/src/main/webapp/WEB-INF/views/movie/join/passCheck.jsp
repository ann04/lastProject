<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.jsp"/>
<div id="body">
		<h1><span>P/W CHECK</span></h1><br><br><br><br>
		<form action="passcheck.go" method="post">
			<input type="password" name="password"><br><br>
			<input type="submit" value="비밀번호확인">
		</form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>