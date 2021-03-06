<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<script>
	var cnt=0;
	function perCnt(perCnt,value){
		cnt=cnt+1;
		if(cnt<perCnt){
			$("#snum").val($("#snum").val()+value+"/");
		}else if(cnt==perCnt){
			$("#snum").val($("#snum").val()+value);
			$("input[name=snums]").prop('disabled',true);
		}else if(cnt>perCnt){
			alert("선택 된 명수가 초과되었습니다.");
		}
	}

</script>
<style type="text/css">
	
input[type=checkbox] {  
    display: none;  
}

input[type=checkbox] + label{
    display: inline-block;  
    cursor: pointer;  
    position: relative;  
    padding-left: 25px;  
    margin-right: 15px;  
    font-size: 13px;
}

input[type=checkbox]+ label:before {     

    content: "";  
    display: inline-block;  
  
    width: 20px;  
    height: 20px;  
  
    margin-right: 10px;  
    position: absolute;  
    left: 0;  
    bottom: 1px;  
    background-color: #ccc;  
    border-radius: 2px; 
    box-shadow: inset 0px 1px 1px 0px rgba(0, 0, 0, .3), 0px 1px 0px 0px rgba(255, 255, 255, .8);  
}
input[type=checkbox]:checked + label:before { 

    content: "x";  /* 체크모양 */
    text-shadow: 1px 1px 1px rgba(0, 0, 0, .2);  
    font-size: 18px; 
    font-weight:800; 
    color: #fff;  
    background:#2f87c1;
    text-align: center;  
    line-height: 18px;  

}

#left {
	float:left;}
#right {
	float:right;}	
</style>
</head>
<body>
<form action="reservation" method="post" name="frm">
	<input type="hidden" name="mid" value="${sc.mid}">
	<input type="hidden" name=cid value="${sc.cid}">
	<input type="hidden" name="viewdate" value="${viewdate}">
	<input type="hidden" name="id" value="${loginsession}">
 	<input type="hidden" name="snum" id="snum">
	<h3><table border="1">
	<tr>
	<td>--------------------------------------screen--------------------------------------</td>
	</tr>
	</table></h3>
	&nbsp;1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	5&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	7&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;8&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	9&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;10&nbsp;&nbsp;&nbsp;&nbsp;
	11&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;12&nbsp;&nbsp;&nbsp;&nbsp;
	13&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;14&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;15
	<div id=left> 
	<c:forEach var="i" items="${hm}">
	<c:if test="${i.key%15==0}">
	<br>
	</c:if>
	<c:if test="${i.value=='□'}">
	<input type="checkbox" id="${i.key}" value="${i.key}" name="snums" class="checkbox-style" onclick="perCnt(${perCnt},this.value)"/><label for="${i.key}"></label>
	</c:if>
	<c:if test="${i.value=='■'}">
	<input type="checkbox" id="f_r" class="checkbox-style" checked="checked" disabled="disabled"/><label for="f_r"></label>
	</c:if>	
	</c:forEach>
	</div>
	<br><input type="submit" value="좌석선택완료">
	
	<div>
	
	</div>
	
</form>
</body>
</html>