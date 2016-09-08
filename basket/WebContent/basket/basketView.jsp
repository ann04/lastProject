<%@page import="com.basket.vo.BasketVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
<head>
<style>
	td,th{
	color:blue;
	}
	p{
		margin:2px;
		padding:2px;
		font-weight:bold;
	}	
</style>

<script>
$(function(){
	$('#checkAll').click(function(){
		if($('#checkAll').prop('checked')){
			$('input[name=choice]:checkbox').each(function(){
				$(this).prop('checked',true);
			
			});
		}else{
			$('input[name=choice]:checkbox').each(function(){
				$(this).prop('checked',false);		
			});
		}
	})
});

/*function sum(count, price, idx){
	tot = count*price;
	alert(tot);
	$("#total"+idx).text(tot);
}	
*/
	
function test(idx){ 
		count = $("#numbers"+idx).val();
		price = $("#price"+idx).text();
		tot = count*price;
		$("#total"+idx).text(tot);
		
		
		
	/* 	preprice=Number($("#total"+idx).text());
		afterprice=Number($("#total"+idx).text(tot));
		
		if(preprice<afterprice){
			gab=afterprice-preprice;
			total=number($("#totalprice").text());
			$("#totalprice").text(total+gab); */
	
	
}

	
$(function(){
	$('#all').click(function(){
			if($('#checkAll').prop('checked')){
				$('input[name=choice]:checkbox').each(function(){
					$(this).prop('checked',true);
				
				});
			}else{
				$('input[name=choice]:checkbox').each(function(){
					$(this).prop('checked',true);		
				});
		}
		})	
	});
	

</script>
</head>

<body>
<h3> 장바구니 </h3>
<table border=1>
<thead>
<tr>
	<th><input type="checkbox" id="checkAll"></th>
	<th width=100px></th>
	<th width=250px>상품 정보</th>
	<th width=100px>Color</th>
	<th width=100px>수량</th>
	<th width=100px>판매가</th>
	<th width=100px>합계</th>
	<th width=100px>구매일자</th>
</tr>
<thead>

<tbody>

 <c:forEach var="dto" items="${lists}" varStatus="status">
	<tr id="row">
	<td><input type="checkbox" name="choice"></td>
	<td></td> 
	
 	<td align="center"> ${dto.productName}</td>
 	<td align="center"> ${dto.color}</td>
 	<td align="center"><input type="text" value=${dto.numbers} id="numbers${status.index}" size=3 ><br>
 					   <%-- <input type="button" value="변경" id="change" size=3 onclick="sum($('#numbers${status.index}').val(),$('#price${status.index}').text(),${status.index})"> --%>
 					    <input type="button" value="변경"  size=3 onclick="test(${status.index})">
 					   </td>
 	<td align="center" id="price${status.index}"> ${dto.price}</td>
 	<td align="center" id="total${status.index}"> ${dto.numbers*dto.price}</td> 	<!-- 합계 -->
 	<td align="center"> ${dto.buydate}</td>
 	
 	</tr>
 	
 <c:set var="hap" value="${hap+dto.numbers*dto.price}" > </c:set> 
 
</c:forEach> 

</tbody>
</table>
<br></br>

<p>총 결제 금액<p>
<table>
<tr><td>주문 상품수</td><td>&nbsp;&nbsp;&nbsp;</td><td> ${count}개 </td></tr>
<tr><td>총 상품금액 </td><td>&nbsp;&nbsp;&nbsp;</td><td id="totalprice"> <c:out value="${hap}"/>원 </td></tr>
<tr><td>배송비 </td><td>&nbsp;&nbsp;&nbsp;</td><td> 0원 </td></tr>
<tr><td>총 결제 금액</td><td>&nbsp;&nbsp;&nbsp;</td><td> <c:out value="${hap}"/>원 </td></tr>
</table>
<p></p>

<input type="button" id="all" value="전체 상품 선택">
<input type="button" value="선택상품 선택">
<input type="button" value="쇼핑계속하기">
</body>
</html>