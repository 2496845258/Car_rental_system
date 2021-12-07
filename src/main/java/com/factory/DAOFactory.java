package com.factory;

import com.dao.ICarDAO;
import com.dao.IOrderDAO;
import com.dao.IUserDAO;
import com.dao.proxy.ICarDAOProxy;
import com.dao.proxy.IOrderDAOProxy;
import com.dao.proxy.IUserDAOProxy;

public class DAOFactory {
	public static ICarDAO getICarDAOInstance() throws Exception{
		return new ICarDAOProxy();
	}
	public static IUserDAO getIUserDAOInstance() throws Exception{
		return new IUserDAOProxy();
	}
	public static IOrderDAO getIOrdreDAOInstance() throws Exception{
		return new IOrderDAOProxy();
	}
}
