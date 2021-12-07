package com.dao.proxy;

import java.util.ArrayList;

import com.dao.ICarDAO;


import com.dbc.DatabaseConnection;
import com.impl.CarDAOImpl;
import com.vo.Car;

public class ICarDAOProxy implements ICarDAO{
	private DatabaseConnection databaseConnection = null;
	private ICarDAO dao = null;

	public ICarDAOProxy() throws Exception{
		this.databaseConnection = new DatabaseConnection();
		this.dao = new CarDAOImpl(this.databaseConnection.getConnection());
	}
	
	public boolean doInsert(Car car) throws Exception {
		boolean flag = false;
		try{
			if ( this.dao.findById(car) == null ) {
				flag = this.dao.doInsert(car);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;

	}

	@Override
	public ArrayList<Car> findAll() throws Exception {


		ArrayList<Car> arr = null;
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
	public Car findById(Car car) throws Exception {

		Car car2 = null;
		try{
			car2 = this.dao.findById(car);
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return car2;

	}

	@Override
	public boolean deleteById(Car car) throws Exception {


		boolean flag = false;
		try{
			if ( this.dao.findById(car) != null ) {
				flag = this.dao.deleteById(car);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;

	}

	@Override
	public boolean doUpdata(Car car) throws Exception {

		boolean flag = false;
		try{
			if ( this.dao.findById(car) != null ) {
				flag = this.dao.doUpdata(car);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.databaseConnection.close(); // 关闭数据库对象
		}
		return flag;

	}

}
