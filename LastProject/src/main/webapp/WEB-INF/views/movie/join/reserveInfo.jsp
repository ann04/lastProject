<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">

table {
	font-family: "Lato","sans-serif";   
}       
table.one {  
	margin-bottom: 3em;
	border-collapse:collapse;   
}  

td {  
	text-align: center;    
	width: 10em;                   
	padding: 1em;      
}      

th {                            
	text-align: center;                
	padding: 1em;
	background-color: #d2d2d2;    
	color: white;       
}         

tr {   
	height: 1em;  
}

table tr:nth-child(even) { 
	background-color: #eee;   
}

table tr:nth-child(odd) { 
	background-color:#fff;    
}
</style>

</head>
<body>
	<jsp:include page="menu.jsp"/>
		<table align="center">
			<tr>
				<th>영화관</th>
				<th>상영관</th>
				<th>영화제목</th>
				<th>상영시간</th>
				<th>좌석</th>
				<th>취소</th>
			</tr>
			<c:forEach items="${res}" var="r">
				<tr>
					<td>${r.key.tname}</td>
					<td>${r.key.cname}</td>
					<td>${r.key.title}</td>
					<td>${r.key.viewdate}</td>
					<td>${r.key.snum}</td>
					<td>
					<c:if test="${r.value==1}">
						취소불가
					</c:if>
					<c:if test="${r.value==0 }">
						<input type="button" value="예매취소" onclick="location.href='reserveCancel.go?rnum=?${r.key.rnum}'">
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<br><br><br><br>
	<jsp:include page="footer.jsp"/>
</body>
</html>