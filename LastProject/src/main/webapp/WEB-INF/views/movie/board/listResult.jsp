<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<style type="text/css">
	.reply{
		width:800px;
	}
</style>
<!-- <script>
$(document).ready(function(){
	$("#reply").click(sendReply);	
	getData(1);

});//document

function sendReply(){
	var content=$("#content").val();
	$.get("list.do", {"content":content}),
	function(data){
		$("#reComment").html(data);
	}
}
function getData(pageNum){
	$.ajax({
		type:"post",
		url:"list.do",
		data:"pageNum="+pageNum,
		success:function(data){
			$("#reComment").html(data);
		},
		error:function(e){
			alert("error:"+e)
		}
	});
}
</script> -->

</head>
<body>
<c:forEach items="${reply}" var="b">
	
	<b align="right">${b.reg_date}</b><br>
	<b>${b.userid}></b>&nbsp;&nbsp;<b>${b.content}</b>
	
	<c:if test="${userId!=null && userId==b.userid}">
		<input type="button" value="삭제" style="float:right" onclick="boarddel.go?${b.repid}">
	</c:if>
	<hr style="border: dotted 1px #d2d2d2;">
	
</c:forEach>
<div>
${pageHtml}
</div>
</body>
</html>