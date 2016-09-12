<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.movies.vo.CinemaVO"%>
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.ibatis.sqlmap.client.SqlMapClient"%>
<%@page import="com.movies.config.Config"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int tid = Integer.parseInt(request.getParameter("tid"));
	
	SqlMapClient sqlMap = Config.getSqlMapInstance();
	
	try {
		
		List<CinemaVO> cv= sqlMap.queryForList("cinD",tid);
		JSONArray jarr =new JSONArray();
		
		for(CinemaVO c:cv){
			JSONObject obj = new JSONObject();
			obj.put("cid",c.getCid());
			obj.put("cname",c.getCname());
			jarr.add(obj);
		}
		out.println(jarr.toString());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
%>
