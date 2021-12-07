package com.controller.car;

import java.io.IOException;

import com.factory.DAOFactory;
import com.vo.Car;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Car_Delete_Servlet
 */
@WebServlet("/Car_Delete_Servlet")
public class Car_Delete_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Car_Delete_Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Car car = new Car();
		car.setCarid(id);
		try {
			if ( DAOFactory.getICarDAOInstance().deleteById(car) ) {
				// 请求重定向
				request.getSession().setAttribute("page", 0);
		        response.sendRedirect("/Car_rental_system/Car_All_Servlet");
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
