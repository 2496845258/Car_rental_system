package com.controller.order;

import java.io.IOException;



import java.util.ArrayList;

import com.factory.DAOFactory;

import com.vo.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Order_All_Servlet
 */
@WebServlet("/Order_All_Servlet")
public class Order_All_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			ArrayList<Order> arr = DAOFactory.getIOrderDAOInstance().findAll();
			if ( arr != null ) {
				request.setAttribute("arr", arr);
				
				Integer integer = 0;
				if (request.getSession().getAttribute("page") == null ) {
					request.getSession().setAttribute("page", integer);
				}else {
					integer = (Integer)request.getSession().getAttribute("page");
				}
				
				
				if ( request.getParameter("value") == null ) {
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/order/order_all.jsp");
			        requestDispatcher.forward(request,response);
				}else {
					if ( request.getParameter("value").equals("1") ) {
						integer = integer + 1;
						integer = integer*10>arr.size()?arr.size()/10:integer;
						request.getSession().setAttribute("page", integer);
					}else if ( request.getParameter("value").equals("0") ) {
						integer = integer - 1;
						integer = integer<0?0:integer;
						request.getSession().setAttribute("page", integer);
					}
					
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/order/order_all.jsp");
			        requestDispatcher.forward(request,response);
				}
			}else {
				// ´íÎóÒ³Ãæ
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
