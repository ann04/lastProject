<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

    <table style="font-family:맑은 고딕; font-size=10pt" align="left" cellpadding="5">
	<c:forEach var="reply" items="${reply}">
	<tr>
	<th style="background-color:#c8c8c8" width=100px>repid</th>
	<td align="center">${reply.repid }</td>
	</tr>
	<tr>
	<th style="background-color:#c8c8c8" width=100px>userid</th>
	<td align="center">${reply.userid }</td>
	</tr>
	<tr>
	<th style="background-color:#c8c8c8" width=100px>content</th>
	<td align="center">${reply.content }</td>
	</tr>
	<tr>
	<th style="background-color:#c8c8c8" width=100px>secret</th>
	<td align="center">${reply.secret }</td>
	</tr>
		<tr>
	<th style="background-color:#c8c8c8" width=100px>reg_date</th>
	<td align="center">${reply.reg_date }</td>
	</tr>
		<tr>
	<th style="background-color:#c8c8c8" width=100px>ref</th>
	<td align="center">${reply.ref }</td>
	</tr>
	<tr>
	<th style="background-color:#c8c8c8" width=100px>re_step</th>
	<td align="center">${reply.re_step }</td>
	</tr>
	<tr>
	<th style="background-color:#c8c8c8" width=100px>re_level</th>
	<td align="center">${reply.re_level}</td>
	</tr>
	<tr>
	<th style="background-color:#c8c8c8" width=100px>ip</th>
	<td align="center">${reply.ip}</td>
	</tr>
	<tr>
	<th style="background-color:#c8c8c8" width=100px>mid</th>
	<td align="center">${reply.mid}</td>
	</tr>
	</c:forEach>
	</table>
	