package com.dao;

import java.util.ArrayList;

import com.vo.User;

public interface IUserDAO {
	public boolean doInsert(User user) throws Exception;
	public ArrayList<User> findAll() throws Exception;
	public User findById( User user ) throws Exception;
	public boolean deleteById( User user ) throws Exception;
	public boolean doUpdata( User user ) throws Exception;
}
