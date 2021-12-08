package com.controller.order;

import java.io.IOException;


import com.factory.DAOFactory;
import com.vo.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Car_Delete_Servlet
 */
@WebServlet("/Order_Delete_Servlet")
public class Order_Delete_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Order order = new Order();
		order.setOrderid(id);
		try {
			if ( DAOFactory.getIOrderDAOInstance().deleteById(order) ) {
				// 请求重定向
				request.getSession().setAttribute("page", 0);
		        response.sendRedirect("/Car_rental_system/Order_All_Servlet");
			}else {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
