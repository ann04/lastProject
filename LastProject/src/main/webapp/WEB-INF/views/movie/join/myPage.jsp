<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	.myPage {
		text-align: center;
	}
	.btn_mem, .btn_res{
	text-align:center;
	margin:50px;
border:1px solid #2a2c2f; -webkit-border-radius: 3px; -moz-border-radius: 3px;border-radius: 3px;font-size:30px;font-family:arial, helvetica, sans-serif; padding: 50px 50px 50px 50px; text-decoration:none; display:inline-block;text-shadow: -1px -1px 0 rgba(0,0,0,0.3);font-weight:bold; color: #FFFFFF;
 background-color: #45484d; background-image: -webkit-gradient(linear, left top, left bottom, from(#45484d), to(#000000));
 background-image: -webkit-linear-gradient(top, #45484d, #000000);
 background-image: -moz-linear-gradient(top, #45484d, #000000);
 background-image: -ms-linear-gradient(top, #45484d, #000000);
 background-image: -o-linear-gradient(top, #45484d, #000000);
 background-image: linear-gradient(to bottom, #45484d, #000000);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#45484d, endColorstr=#000000);
}

.btn_mem:hover, .btn_res:hover{
 border:1px solid #151617;
 background-color: #2d2f32; background-image: -webkit-gradient(linear, left top, left bottom, from(#2d2f32), to(#1a1a1a));
 background-image: -webkit-linear-gradient(top, #2d2f32, #1a1a1a);
 background-image: -moz-linear-gradient(top, #2d2f32, #1a1a1a);
 background-image: -ms-linear-gradient(top, #2d2f32, #1a1a1a);
 background-image: -o-linear-gradient(top, #2d2f32, #1a1a1a);
 background-image: linear-gradient(to bottom, #2d2f32, #1a1a1a);filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr=#2d2f32, endColorstr=#1a1a1a);
}
</style>
</head>
<body>
<jsp:include page="menu.jsp"/>
	<div class="myPage">
		<img src="/resources/images/myPage.png">
	</div>
	<div align="center">
		<input type="button" value="회원 정보" class="btn_mem" onclick="location.href='passCheckform'">
		<input type="button" value="예매 정보" class="btn_res" onclick="location.href='reservecheck.go'">
	</div>
<jsp:include page="footer.jsp"/>
</body>
</html>