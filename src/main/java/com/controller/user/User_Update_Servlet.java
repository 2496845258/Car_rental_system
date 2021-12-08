package com.controller.user;

import java.io.IOException;






import com.factory.DAOFactory;

import com.vo.User;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_Update_Servlet
 */
@WebServlet("/User_Update_Servlet")

public class User_Update_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public User_Update_Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserid(Integer.parseInt((request.getParameter("userid"))));
		user.setAccount(request.getParameter("account"));
		user.setPasswor(request.getParameter("passwor"));
		user.setUsername(request.getParameter("username"));
		user.setTelephone(request.getParameter("telephone"));
		
		System.out.println(user.getAccount()+user.getPasswor()+user.getTelephone()+user.getUsername()+user.getUserid());
		
		try {
			if ( DAOFactory.getIUserDAOInstance().doUpdata(user) ) {
				// 请求重定向
				request.getSession().setAttribute("page", 0);
		        response.sendRedirect("/Car_rental_system/User_All_Servlet");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
