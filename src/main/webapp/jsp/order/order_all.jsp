<%@page import="com.vo.Order"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看订单全部信息</title>
	</head>
	<body>
		<tr>
				<td>订单编号</td>
				<td>用户编号</td>
				<td>车辆编号</td>
				<td>用户姓名</td>
		</tr><br>
					
				<%	
					
					ArrayList<Order> arr = (ArrayList<Order>)request.getAttribute("arr");
					Integer integer = (Integer)session.getAttribute("page");
					
					int j = 10*integer;
					for( int i = j; i<j+10; i++ ) {
						if ( i < arr.size()) {
				%>			
				<br>
				<tr>
							<td>
								<% 
									Integer id = arr.get(i).getOrderid();
									String url = "/Car_rental_system/Order_Id_Servlet?id=" + id;
								%>
								<a href=<%=url %> > <%=id %></a>
							</td>
							<td><%=arr.get(i).getUserid()%> </td>
							<td><%=arr.get(i).getCarid()%> </td>
							<td><%=arr.get(i).getUsername()%> </td>
								
				</tr>
				<%
	
						}
					}
				%>
				
				<br>
				<a href="/Car_rental_system/jsp/order/order_insert.jsp">
					<input name="新增汽车信息" type="button" id="btn1" title="不知道是什么意思" value="新增订单信息" />
				</a>
				
				
				<a href="/Car_rental_system/Order_All_Servlet?value=0">
					<input name="上一页" type="button" id="btn1" title="不知道是什么意思" value="上一页" />
				</a>
				<a href="/Car_rental_system/Order_All_Servlet?value=1">
					<input name="下一页" type="button" id="btn1" title="不知道是什么意思" value="下一页" />
				</a>
				
				<br>
				<a href="/Car_rental_system/jsp/admin.jsp">
					<input name="主页" type="button" id="btn1" title="不知道是什么意思" value="主页" />
				</a>
	</body>
</html>