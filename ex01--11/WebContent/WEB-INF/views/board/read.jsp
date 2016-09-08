<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
	$(document).ready(function(){
		var formObj = $("form[role='form']");
		console.log(formObj);
		$(".btn-warnig").on("click",function(){
			formObj.attr("action", "/board/modify");
			formObj.attr("method", "get");
			formObj.submit();
		});	
		$(".btn-danger").on("click",function(){
			formObj.attr("action", "/board/remove");
			formObj.submit();
		});	
		$(".btn-primary").on("click",function(){
			self.location="/board/listCri";
		});	
	});
</script>
</head>
<body>
<%@include file="../include/header.jsp" %>
<form role="form" method="post">
	<input type="hidden" name="bno" value="${read.bno}">
</form>
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control"
				value="${read.title}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content"
			rows="3" readonly="readonly">${read.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control"
				value="${read.writer}" readonly="readonly">
		</div>
	</div>
	<!-- /.box-body -->
	<div class="box-footer">
		<button type="submit" class="btn btn-warnig" >Modify</button>
		<button type="submit" class="btn btn-danger">Remove</button>
		<button type="submit" class="btn btn-primary">List All</button>
	</div>
<%@include file="../include/footer.jsp" %>
</body>
</html>