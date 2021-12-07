package com.dao;

import java.util.ArrayList;
import com.vo.Order;

public interface IOrderDAO {
	public boolean doInsert(Order order) throws Exception;
	public ArrayList<Order> findAll() throws Exception;
	public Order findById (Order order) throws Exception;
	public boolean deleteById (Order order) throws Exception;
	public boolean doUpdata (Order order) throws Exception;
}
