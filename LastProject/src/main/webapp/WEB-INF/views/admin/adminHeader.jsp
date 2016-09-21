<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>관리자 페이지 입니다.</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css" media="screen and (max-width : 568px)">
	<script type="text/javascript" src="/resources/js/mobile.js"></script>
</head>
<body>
<div id="header">
		<ul id="navigation">
			<li class="selected">
				<a href="adminMain.jsp">home</a>
			</li>
			<li>
				<a href="adminmovieall">movie management</a>
			</li>
			<li>
				<a href="theaterview">cinema management</a>
			</li>
			<c:if test="${adloginSession!=null}">
			<li>
				<a href="adminlogout">logout</a>
			</li>
			</c:if>	
		</ul>
	</div>
</body>
</html>