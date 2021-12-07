package com.controller.car;


import java.io.IOException;

import com.factory.DAOFactory;
import com.vo.Car;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Update_Servlet
 */
@WebServlet("/Car_Update_Servlet")
public class Car_Update_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Car car = new Car();
		car.setCarid( Integer.parseInt( request.getParameter("carid")));
		car.setLicense( request.getParameter("license"));
		car.setRent( request.getParameter("rent"));
		
		try {
			if ( DAOFactory.getICarDAOInstance().doUpdata(car) ) {
		        response.sendRedirect("/Car_rental_system/Car_All_Servlet");
			}else {
				// 错误信息
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
		doGet(request, response);
	}

}
