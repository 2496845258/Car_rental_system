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

@WebServlet("/Car_Id_Servlet")
public class Car_Id_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Car car = new Car();
		car.setCarid(id.intValue());
		try {
			Car car2 = DAOFactory.getICarDAOInstance().findById(car);
			if ( car2 != null ) {
				request.setAttribute("car", car2);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/car/car_update.jsp");
		        requestDispatcher.forward(request,response);
			}else {
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
		doGet(request, response);
	}

}
