package com.controller.order;

import java.io.IOException;








import com.factory.DAOFactory;

import com.vo.Order;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Order_Id_Servlet
 */
@WebServlet("/Order_Id_Servlet")
public class Order_Id_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Order_Id_Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Order order = new Order();
		order.setOrderid(id.intValue());
		try {
			Order order2 = DAOFactory.getIOrderDAOInstance().findById(order);
			if ( order2 != null ) {
				request.setAttribute("order", order2);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/order/order_update.jsp");
		        requestDispatcher.forward(request,response);
			}else {
				System.out.print("gg");
				// 错误信息，定时跳转
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
