<%@page import="com.vo.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>查看用户全部信息</title>
	</head>
	<style>
		*{
			margin: 0;
			padding: 0;
		}       
		ol,ul{
			list-style-type:none;
		}
		.left{
			float:left;/*左浮动*/
		}
		.right{
			float:right;  
		}
		body{
			background:#e3e4e5;
		}
		table {
			position:abslute;
			width: 90%;
			background: #ccc;
			margin: auto;
			margin-top:-150px;
			border-collapse: collapse;/*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*/	
			text-decoration: none;
		}				
		th,td {
			height: 30px;
			line-height: 30px;
			text-align: center;
			border: 1px solid #ccc;
		}		
		th {
			background: #eee;
			font-weight: normal;
		}		
		tr {
			background: #fff;
		}		
		tr:hover {
			background: #cc0;
		}		
		td a {
			color: #06f;
			text-decoration: none;
		}		
		td a:hover {
			color: #06f;
			text-decoration: underline;
		}
		#box{
			width: 380px;
			margin: 30px auto;
			font-family: 'Microsoft YaHei';
			font-size: 14px;
			float: right;
		}			
		#header {
			background-color:black;
			color:white;
			text-align:center;
			padding:5px;
			height:40px;
		}
		#top{
			height:50px;
			width:100%;
		}
		#top li{
			float:right;
			margin:0px 15px;
			line-height:60px;
		}
		#top li a{
			color:black;
			font-weight:bold;
			text-decoration: none;
		}
		#bottom{
			width:1200px;
			height:440px;
			text-align:center;
			
		}
		
		#foot{
			height:60px;
		}
		#foot li{
			float:right;
			margin:0px 15px;
			line-height:60px;
		}
		#foot li a{
			color:black;
			font-weight:bold;
			text-decoration: none;
		}
		
		#foot1{
			float:right;
			height:40px;
			width:100%;
			background-color:black;			    
		}
	</style>
	<body>
		
		<div id="header">
			<h1>User information</h1>
		</div>
		
		<div id="top">
			<ul class="right">
				
			</ul>			
		</div>
		
		<div id="bottom">
			
				
		<table   border="1">
			<tr>
				<td>编号</td>
				<td>账号</td>
				<td>密码</td>
				<td>电话</td>
				<td>姓名</td>
			</tr>
			
			
					<%	
					
						ArrayList<User> arr = (ArrayList<User>)request.getAttribute("arr");
						Integer integer = (Integer)session.getAttribute("page");
						
						int j = 10*integer;
						for( int i = j; i<j+10; i++ ) {
							if ( i < arr.size()) {
					%>	
					<br>
					<tr>
								
							<td>
								<% 
									Integer id = arr.get(i).getUserid();
									String url = "/Car_rental_system/User_Id_Servlet?id=" + id;
								%>
								<a href=<%=url %> > <%=id %></a>
							</td>
							<td><%=arr.get(i).getAccount()%> </td>
							<td><%=arr.get(i).getPasswor()%> </td>
							<td><%=arr.get(i).getUsername()%> </td>
							<td><%=arr.get(i).getTelephone()%> </td>
					</tr>
					<%
		
							}
						}
					%>
				
				
		</table>
		
			
		
		
		
		</div>
		
		<div id="foot">
		
			<ul class="right">
					
				<li>
					<a href="/Car_rental_system/jsp/user/user_insert.jsp">
						新增用户信息
					</a>
				</li>
				
				<li>
					<a href="/Car_rental_system/User_All_Servlet?value=0">
						上一页
					</a>
				</li>
				
				<li>
					<a href="/Car_rental_system/User_All_Servlet?value=1">
						下一页
					</a>	
				</li>
				
				
			</ul>			
			<br>
		
		</div>
		
		<div id="foot1">
	
		</div>
						
				
	</body>
</html>
