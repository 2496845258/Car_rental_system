package com.dao.proxy;

import java.util.ArrayList;


import com.dao.IOrderDAO;
import com.dbc.DatabaseConnection;

import com.impl.OrderDAOImpl;

import com.vo.Order;

public class IOrderDAOProxy implements IOrderDAO{
	
	private DatabaseConnection databaseConnection = null;
	private IOrderDAO dao = null;

	public IOrderDAOProxy() throws Exception{
		this.databaseConnection = new DatabaseConnection();
		this.dao = new OrderDAOImpl(this.databaseConnection.getConnection());
	}
	@Override
	public boolean doInsert(Order order) throws Exception {
		boolean flag = false;
		try{
			if ( this.dao.findById(order) == null ) {
				flag = this.dao.doInsert(order);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;
	}

	@Override
	public ArrayList<Order> findAll() throws Exception {
		
		ArrayList<Order> arr = null;
		try{
			arr = this.dao.findAll();
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close();
		}
		return arr;

	}

	@Override
	public Order findById(Order order) throws Exception {
		
		Order order2 = null;
		try{
			order2 = this.dao.findById(order);
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return order2;
	}

	@Override
	public boolean deleteById(Order order) throws Exception {
		
		boolean flag = false;
		try{
			if ( this.dao.findById(order) != null ) {
				flag = this.dao.deleteById(order);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;
	}

	@Override
	public boolean doUpdata(Order order) throws Exception {
		boolean flag = false;
		try{
			if ( this.dao.findById(order) != null ) {
				flag = this.dao.doUpdata(order);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;

	}

}
