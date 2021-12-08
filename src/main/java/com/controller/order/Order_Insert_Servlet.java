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
 * Servlet implementation class Order_Insert_Servlet
 */
@WebServlet("/Order_Insert_Servlet")
public class Order_Insert_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Order_Insert_Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Order order = new Order();

		
		order.setUserid(Integer.parseInt(request.getParameter("userid")));
		order.setCarid(Integer.parseInt(request.getParameter("carid")));
		order.setUsername(request.getParameter("username"));
		try {
			if ( DAOFactory.getIOrderDAOInstance().doInsert(order) ) {
				// 请求重定向
				request.getSession().setAttribute("page", 0);
		        response.sendRedirect("/Car_rental_system/Order_All_Servlet");
			}else {
				//错误提示
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
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
