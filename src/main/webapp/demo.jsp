<%@page import="model.DBconnect.HibernateUtil"%> 
<%@page import="org.hibernate.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 

<%
out.println( HibernateUtil.getSessionFactory());
 %>
	
</body>
</html>