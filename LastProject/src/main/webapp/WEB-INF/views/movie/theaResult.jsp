<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<span>영화관선택</span>
<c:forEach items="${theater}" var="t">
<div id="${t.tid}" onclick="javascript:theaClick(this)">
${t.tname}
</div>
</c:forEach>