package com.controller.user;

import java.io.IOException;






import com.factory.DAOFactory;

import com.vo.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_Id_Servlet
 */
@WebServlet("/User_Id_Servlet")

public class User_Id_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public User_Id_Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id = Integer.parseInt(request.getParameter("id"));
		User user = new User();
		user.setUserid(id.intValue());
		try {
			User user2 = DAOFactory.getIUserDAOInstance().findById(user);
			if ( user2 != null ) {
				request.setAttribute("user", user2);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/user/user_update.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
