<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>영화보자</title>
	<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/mobile.css" media="screen and (max-width : 568px)">
	<script type="text/javascript" src="/resources/js/mobile.js"></script>
	<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
	<style type="text/css">
textarea {
    resize:none;
}
</style>
<script>

$(document).ready(function(){
	$("#submit").click(sendIt);	
	getData(1);
/* 	function(data){
		$("#results").html(data);
	};
	getData(1,"","");
			 */
});//document

function getData(pageNum){
	var mid = $("#mid").val();
	$("#results").load("listreply?pageNum="+pageNum+"&mid="+mid,
			function(data){
				$("#results").html(data);
			});
}

function sendIt(){
	var content=$("#content").val();
	var mid = $("#mid").val();
	$.ajax({
		type:"get",
		url:"insertreply",
		data: "content="+content+"&mid="+mid+"&userid=${sessionScope.loginsession}",
		success:function(data){
			$("#results").html(data);
		},
		beforeSend:show,
		error:function(e){
			alert("error:"+e)
		}
	}); //ajax
} //sendIt

function show(){
	if(!$("#content").val()){//내용
		alert("내용을 입력하세요.");
		$("#content").focus();
		return false;
	}
	if("${sessionScope.loginsession}"==""){
		alert("로그인후 이용가능합니다.");
		return false;
	}
	return true;
} //show
</script>

</head>
<body>
	<jsp:include page="menu.jsp"/>
	<div id="body">
		<h1><span>Movie View</span></h1>
		<div>
			<img src="/resources/images/${mov.img}" alt="" width="400px" height="550px">
			<div class="article">
				<h4>${mov.title}</h4>
				<a href="reserveview.go?mid=${mov.mid}" class="more">예매하기</a>
				<p>
				${mov.content}
				</p>
			</div>
		</div>
		<div>
			
		</div>
		
	</div>

	<form action="insertreply" method="get" name="form">
	<input type="hidden" id="mid" name="mid" value="${mov.mid}">
		<table align="center">
		
		<tr>
			<td>입력</td>
			<td align="left">
				<textarea id="content" name="content" rows=4 cols=80 maxlength=800 ></textarea>
			</td>
		
			
			<td align="center"><input type="button" value="입력" id="submit">
		</td>
		</tr>
		</table>
	</form>
	<br>
	
	<br><br><br>
	<!-- 결과 출력 부분 -->
	<div id="results" ></div>

	<jsp:include page="footer.jsp"/>

</body>

</html>
