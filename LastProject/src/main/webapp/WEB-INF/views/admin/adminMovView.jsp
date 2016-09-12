<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="adminHeader.jsp"/>
<form action="movieinsert.go" method="post" enctype="multipart/form-data">	
	<div id="body">
		<h1><span>An's 영화 수정</span></h1>
		

		<div>
			<table align="center">
			<tr>
				<td>
					<img  width="200" height="280" src="../movie/images/${mov.img}" alt="your image" /><br>
	 			</td>
	 			<td>
	 				<input type="hidden" value="${mov.mid}">
	 				제 목 : ${mov.title}<br>
		 			감 독 : ${mov.title}<br>
		 			줄거리:${mov.content}<br>
		 			영화관:
		 			<select name="theater" id="theater">
		 				<option value="0"> 선택하세요</option>
		 				<c:forEach items="${theater}" var="t">
		 					<option value="${t.tid}">${t.tname}</option>
		 				</c:forEach>	 				
	 				</select>
	 			<div class="cinema">
	 			</div>
	 			</td>
	 		</tr>
	 		</table>	
	 			
			<div class="article">
			
				<input type="submit" value="수정" class="aa"/> 			
				
			</div>
		</div>
	</div>
</form>	
<jsp:include page="adminFooter.jsp"/>
</body>
</html>