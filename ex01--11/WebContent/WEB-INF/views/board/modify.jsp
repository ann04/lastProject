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
		
		$(".btn-primary").on("click", function(){
			formObj.submit();
		});
		$(".btn-warning").on("click", function(){
			self.location="/board/list";
		});
	});
</script>
</head>
<body>
<%@include file="../include/header.jsp" %>
<form role="form" method="post">
	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">BNO</label>
			<input type="text" name="bno" class="form-control"
				value="${read.bno}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control"
				value="${read.title}">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content"
			rows="3">${read.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control"
				value="${read.writer}">
		</div>
	</div>
	<!-- /.box-body -->
	<div class="box-footer">
		<button type="submit" class="btn btn-primary" >Save</button>
		<button type="submit" class="btn btn-warning">Cancel</button>
	</div>
</form>
<%@include file="../include/footer.jsp" %>
</body>
</html>