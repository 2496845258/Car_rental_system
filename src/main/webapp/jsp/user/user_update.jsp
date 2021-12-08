<%@page import="com.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新用户信息</title>
	</head>
	<body>
		<%
		User user = (User)request.getAttribute("user");
		%>
	
		<form action="/Car_rental_system/User_Update_Servlet" method="post">
			编号：<input type="text" name="userid" readonly="readonly" value=<%=user.getUserid() %>><br>
			账号：<input type="text" name="account" value=<%=user.getAccount() %>><br>
			密码：<input type="text" name="passwor" value=<%= user.getPasswor()%>><br>
			姓名：<input type="text" name="username" value=<%= user.getUsername()%> ><br>
			电话：<input type="text" name="telephone" value=<%= user.getTelephone()%> ><br>
			<input type="submit" value="更新">
		</form>
		
		<% 
			String url = "/Car_rental_system/User_Delete_Servlet?id=" + user.getUserid();
		%>
		<a href=<%=url %>>
			<input name="删除" type="button" id="btn1" title="不知道是什么意思" value="删除" />
		</a>
	</body>
</html>