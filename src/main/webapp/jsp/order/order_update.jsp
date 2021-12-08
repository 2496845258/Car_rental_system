<%@page import="com.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新车辆信息</title>
	</head>
	<body>
		<%
			Order order = (Order)request.getAttribute("order");
		%>
	
		<form action="/Car_rental_system/Order_Update_Servlet" method="post">
			订单编号：<input type="text" name="orderid"  readonly="readonly" value=<%=order.getOrderid() %>><br>
			用户编号：<input type="text" name="userid"  value=<%=order.getUserid() %>><br>
			车辆编号：<input type="text" name="carid" value=<%=order.getCarid() %>><br>
			用户姓名：<input type="text" name="username" value=<%=order.getUsername()%> ><br>
			<input type="submit" value="更新">
		</form>
		
		<% 
			String url = "/Car_rental_system/Order_Delete_Servlet?id=" + order.getOrderid();
		%>
		<a href=<%=url %>>
			<input name="删除" type="button" id="btn1" title="不知道是什么意思" value="删除" />
		</a>
	</body>
</html>