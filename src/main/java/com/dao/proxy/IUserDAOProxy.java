package com.dao.proxy;

import java.util.ArrayList;

import com.dao.IUserDAO;
import com.dbc.DatabaseConnection;
import com.impl.UserDAOImpl;
import com.vo.User;


public class IUserDAOProxy implements IUserDAO {
	private DatabaseConnection databaseConnection = null;
	private IUserDAO dao = null;

	public IUserDAOProxy() throws Exception{
		this.databaseConnection = new DatabaseConnection();
		this.dao = new UserDAOImpl(this.databaseConnection.getConnection());
	}
	@Override
	public boolean doInsert(User user) throws Exception {
		boolean flag = false;
		try{
			if ( this.dao.findById(user) == null ) {
				flag = this.dao.doInsert(user);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;
	}

	@Override
	public ArrayList<User> findAll() throws Exception {
		ArrayList<User> arr = null;
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
	public User findById(User user) throws Exception {
		User user2 = null;
		try{
			user2 = this.dao.findById(user);
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return user2;
	}

	@Override
	public boolean deleteById(User user) throws Exception {
		boolean flag = false;
		try{
			if ( this.dao.findById(user) != null ) {
				flag = this.dao.deleteById(user);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;
	}

	@Override
	public boolean doUpdata(User user) throws Exception {
		boolean flag = false;
		try{
			if ( this.dao.findById(user) != null ) {
				flag = this.dao.doUpdata(user);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;
	}

}
