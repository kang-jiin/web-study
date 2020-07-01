<%@page import="member.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="menu.jsp"/>
	<% ArrayList<MemberVO> mlist = (ArrayList<MemberVO>)request.getAttribute("mlist"); %>
	
	<h1>회원 관리</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>패스워드</td>
			<td>이름</td>		
		</tr>
	<%
		for(MemberVO mvo : mlist){
			out.print("<tr>");
			out.print("<td>"+mvo.getId()+"</td>");
			out.print("<td>"+mvo.getPwd()+"</td>");
			out.print("<td>"+mvo.getName()+"</td>");
			out.print("</tr>");
		}
		
	%>
		
	</table>
	
	
	
	
	
	
	
	
	
	
</body>
</html>