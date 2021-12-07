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
 * Servlet implementation class Car_Insert_Servlet
 */
@WebServlet("/Car_Insert_Servlet")
public class Car_Insert_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Car car = new Car();
		car.setLicense( request.getParameter("license"));
		car.setRent(request.getParameter("rent"));
		
		try {
			if ( DAOFactory.getICarDAOInstance().doInsert(car) ) {
				// �����ض���
				request.getSession().setAttribute("page", 0);
		        response.sendRedirect("/Car_rental_system/Car_All_Servlet");
			}else {
				//������ʾ
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
