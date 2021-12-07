package com.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.dao.IOrderDAO;
import com.vo.Order;

public class OrderDAOImpl implements IOrderDAO{


	
	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	public OrderDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	public boolean doInsert(Order order) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag=false;
		String sql="INSERT INTO orders(userid,username,carid) VALUES(?,?,?)";
		
		this.preparedStatement=this.connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, order.getUserid());
		this.preparedStatement.setString(2, order.getUsername());
		this.preparedStatement.setInt(3, order.getCarid());
		if(this.preparedStatement.executeUpdate()>0){
			flag=true;
		}
		this.preparedStatement.close();
		return flag;

	}

	@Override
	public ArrayList<Order> findAll() throws Exception {
		// TODO 自动生成的方法存根

		
		Order order = null;
		
		ArrayList<Order> all=new ArrayList<Order>();
		String sql="SELECT * FROM orders ";
		
		this.preparedStatement=this.connection.prepareStatement(sql);
		ResultSet rs=this.preparedStatement.executeQuery();
		
		while (rs.next()) {
			order = new Order();
			
			order.setOrderid(rs.getInt(1));
			order.setUserid(rs.getInt(2));
			order.setUsername(rs.getString(3));
			order.setCarid(rs.getInt(4));
			
			all.add(order);
		}
		
		if ( all.size() == 0 ) {
			all = null;
		}
		this.preparedStatement.close();

		return all;

	}

	@Override
	public Order findById(Order order) throws Exception {
		// TODO 自动生成的方法存根

		Order order2 = null;
		String sql = "SELECT * FROM orders WHERE orderid=?";
		
		this.preparedStatement=this.connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, order.getOrderid());
		ResultSet rs=this.preparedStatement.executeQuery();
		
		if(rs.next()){
			
			order2 = new Order();
			
			order2.setOrderid(rs.getInt(1));
			order2.setUserid(rs.getInt(2));
			order2.setUsername(rs.getString(3));
			order2.setCarid(rs.getInt(4));
		}
		
		this.preparedStatement.close();

		return order2;

	}

	@Override
	public boolean deleteById(Order order) throws Exception {
		// TODO 自动生成的方法存根

		boolean flag = false;
		String sql = "delete from orders where orderid=?" ;
		this.preparedStatement = this.connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, order.getOrderid());
		if(this.preparedStatement.executeUpdate()>0){
			flag=true;
		}
		
		this.preparedStatement.close();
		
		return flag;

	}

	@Override
	public boolean doUpdata(Order order) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		
		String sql = "update orders set userid=?,username=?,carid=? where orderid=?";
		
		this.preparedStatement=this.connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, order.getUserid());
		this.preparedStatement.setString(2, order.getUsername());
		this.preparedStatement.setInt(3, order.getCarid());
		this.preparedStatement.setInt(4, order.getOrderid());
		
		if(this.preparedStatement.executeUpdate()>0){
			flag=true;
		}
		
		this.preparedStatement.close();
		
		return flag;

	}

}
