<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html> 
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>영화등록</title>
<link rel="stylesheet" type="text/css" href="movie/css/style.css">
<link rel="stylesheet" type="text/css" href="movie/css/mobile.css" media="screen and (max-width : 568px)">
<script type="text/javascript" src="movie/js/mobile.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
	$(document).ready(function(){
		 $("#theater").change(function(){
			 $.get("cinemaResult.jsp",{"tid":$(this).val()},//zipCheckPro.jsp?dong=$("#dong").val()
					function(data){
					
					data=$.parseJSON(data);
					var htmlStr = "";
					
					htmlStr+="<select onchange='cidSend(this.value)'>";
					htmlStr+="<option value='0'>선택하세요</option>"
					for(var i=0;i<data.length;i++){
						addr=data[i].sido+" "+data[i].gugun+" "+data[i].dong+" "+data[i].bunji;
						htmlStr+="<option value='"+data[i].cid+"'>"+data[i].cname+"</option>";	
					}
					htmlStr+="</select>";
					$(".cinema").html(htmlStr);
					
				});
		 });
	});
	function readURL(input) {
	    if (input.files && input.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function (e) {
	            $('#blah').attr('src', e.target.result);
	        }
	        reader.readAsDataURL(input.files[0]);
	    }
	}
	
	function check(){
		if($("#title").val()==0){
			alert("영화제목을 입력하세요");
			return false;
		}
		if($("#director").val()==0){
			alert("감독을 입력하세요");
			return false;
		}
		if($("#content").val()==0){
			alert("줄거리를 입력하세요");
			return false;
		}
		if($("#theater").val()==0){
			alert("영화관을 선택하세요");
			return false;
		}
	}
	
	function cidSend(cid){
		$("#cid").val(cid);
	}
</script>
<style type="text/css">
.cinema{
	display:inline;
}
</style>
 </head>


<body>
<jsp:include page="adminHeader.jsp"/>
<form action="movieinsert" method="post" enctype="multipart/form-data">	
	<div id="body">
		<h1><span>An's 영화 등록</span></h1>
		

		<div>
			<table align="center">
			<tr>
				<td>
					<img id="blah" src="#" alt="your image" /><br>
		 			<input type="file" name="img" accept="image/*" onchange="readURL(this);">
	 			</td>
	 			<td>
	 				제 목 : <input type="text" id="title" name="title"><br>
		 			감 독 : <input type="text" id="director" name="director"><br>
		 			줄거리:<textarea id="content" name="content"></textarea><br>
		 			영화관:
		 			<select name="tid" id="theater">
		 				<option value="0"> 선택하세요</option>
		 				<c:forEach items="${theater}" var="t">
		 					<option value="${t.tid}">${t.tname}</option>
		 				</c:forEach>	 				
	 				</select>
	 				<div class="cinema">
		 			</div>
		 			<input type="hidden" id="cid" name="cid">
	 			</td>
	 		</tr>
	 		</table>	
	 			
			<div class="article">
			
				<input type="submit" value="등록" class="aa" onclick="return check();"/> 			
				
			</div>
		</div>
	</div>
</form>	
<jsp:include page="adminFooter.jsp"/>
</body> 
 </body>
</html>