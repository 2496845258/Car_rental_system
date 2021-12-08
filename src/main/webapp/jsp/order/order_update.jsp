<%@page import="com.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>更新订单信息</title>
		<style>
			*{
	            margin: 0;
	            padding: 0;
	        }       
			ol,ul{
				list-style-type:none;
			}
	        body{
	            background:#e3e4e5;
	        }
	        #header {
			    background-color:black;
			    color:white;
			    text-align:center;
			    padding:5px;
			    height:40px;
			}
			#top{
				height:100px;
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
			#middle{
				height:430px;	
			}
			.login{
				position:absolute;
				top:46%;
				margin-top:-190px;
				left:50%;
				margin-left:-200px;
				width:400px;
				height:450px;
				border-radius:25px;
				text-align:center;
				padding:5px 40px;
				background-color:white;
			}
			
			input{
				background-color:white;
				width:60%;
				height:40px;
				margin-bottom:25px;
				border:none;
				border-bottom:2px solid silver;
				border-radius:5px;
				outline:none;
				font-size:15px;
		    }
			
		    p{
				font-size:30px;
				font-weight:500;
			}
			#btn{
				background-color:black;
				width:38%;
				height:48px;
				border-radius:8px;
				font-size:20px;
				font-weight:400;
				color:white
				
			}
			#btn:hover{
				background-color:#59c2a0;
			}
			#foot{
				height:40px;
			}
			#foot1{
				float:right;
				height:40px;
				width:100%;
				background-color:black;			    
			}
		</style>
	</head>
	<body>
	
		<div id="header">
			<h1>Insert</h1>
		</div>
		<div id="top">
			<ul class="right">
				<li><a href="#">主页</a></li>
				<li><a href="#">注册</a></li>
			</ul>			
		</div>
		<div id="middle">
		
		<%
			Order order = (Order)request.getAttribute("order");
		%>
	
		
		<form action="/Car_rental_system/Order_Update_Servlet" method="post" class="login">
			<br>
			<p>编辑订单信息</p>
			<br>
			订单编号：<input type="text" name="orderid"  readonly="readonly" value=<%=order.getOrderid() %>><br>
			用户编号：<input type="text" name="userid"  value=<%=order.getUserid() %>><br>
			车辆编号：<input type="text" name="carid" value=<%=order.getCarid() %>><br>
			用户姓名：<input type="text" name="username" value=<%=order.getUsername()%> ><br>
			<input type="submit" value="更新">
		
		<% 
			String url = "/Car_rental_system/Order_Delete_Servlet?id=" + order.getOrderid();
		%>
		<a href=<%=url %>>
			<input name="删除" type="button" id="btn1" title="不知道是什么意思" value="删除" />
		</a>
		
		</form>
		
		
		

	 		
	 			
	 		
		</div>
		
		<div id="foot">
			
		</div>
		
		<div id="foot1">
	
		</div>
	</body>
</html>