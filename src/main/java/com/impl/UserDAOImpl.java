package com.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dao.IUserDAO;
import com.vo.User;

public class UserDAOImpl implements IUserDAO {

	private Connection connection=null;
	private PreparedStatement preparedStatement=null;
	public UserDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	public boolean doInsert(User user) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag=false;
		String sql="INSERT INTO user(account,password,username,telephone) VALUES(?,?,?,?)";
		this.preparedStatement=this.connection.prepareStatement(sql);
		
		this.preparedStatement.setString(1, user.getAccount());
		this.preparedStatement.setString(2, user.getPasswor());
		this.preparedStatement.setString(3, user.getUsername());
		this.preparedStatement.setString(4, user.getTelephone());
		
		if(this.preparedStatement.executeUpdate()>0){
			flag=true;
		}
		
		this.preparedStatement.close();
		
		return flag;
	}

	@Override
	public ArrayList<User> findAll() throws Exception {
		// TODO 自动生成的方法存根
		User user = null;
		
		ArrayList<User> all=new ArrayList<User>();
		String sql="SELECT * FROM user ";
		
		this.preparedStatement=this.connection.prepareStatement(sql);
		ResultSet rs=this.preparedStatement.executeQuery();
		
		while (rs.next()) {
			
			user = new User();
			
			user.setUserid(rs.getInt(1));
			user.setAccount(rs.getString(2));
			user.setPasswor(rs.getString(3));
			user.setUsername(rs.getString(4));
			user.setTelephone(rs.getString(5));
	
			all.add(user);
		}
		
		if ( all.size() == 0 ) {
			all = null;
		}
		return all;
	}

	@Override
	public User findById(User user) throws Exception {
		// TODO 自动生成的方法存根
		User user2 = null;
		
		String sql="SELECT * FROM user WHERE userid=?";
		
		this.preparedStatement=this.connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, user.getUserid());
		ResultSet rs=this.preparedStatement.executeQuery();
		
		if(rs.next()){
			
			user2 = new User();
			
			user2.setUserid(rs.getInt(1));
			user2.setAccount(rs.getString(2));
			user2.setPasswor(rs.getString(3));
			user2.setUsername(rs.getString(4));
			user2.setTelephone(rs.getString(5));
			
		}
		
		this.preparedStatement.close();

		return user2;
	}

	@Override
	public boolean deleteById(User user) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		String sql = "delete from user where userid=?" ;
		this.preparedStatement = this.connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, user.getUserid());
		
		if(this.preparedStatement.executeUpdate()>0){
			flag=true;
		}
		
		this.preparedStatement.close();
		
		return flag;
	}

	@Override
	public boolean doUpdata(User user) throws Exception {
		// TODO 自动生成的方法存根
		boolean flag = false;
		
		String sql = "update user set  account=?,password=?,username=?,telephone=? where userid=?";
		
		this.preparedStatement=this.connection.prepareStatement(sql);
		
		this.preparedStatement.setString(1, user.getAccount());
		this.preparedStatement.setString(2, user.getPasswor());
		this.preparedStatement.setString(3, user.getUsername());
		this.preparedStatement.setString(4, user.getTelephone());
		this.preparedStatement.setInt(5, user.getUserid());
		
		if(this.preparedStatement.executeUpdate()>0){
			flag=true;
		}
		
		this.preparedStatement.close();
		
		return flag;
	}

}
