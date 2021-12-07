package com.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import com.dao.ICarDAO;
import com.vo.Car;

public class CarDAOImpl implements ICarDAO{

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	public CarDAOImpl( Connection connection ) {
		super();
		this.connection = connection;
	}
	
	@Override
	public boolean doInsert(Car car) throws Exception {
		boolean flag = false;
		String sql="INSERT INTO car(license,rent) VALUES(?,?)";
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		this.preparedStatement.setString(1, car.getLicense());
		this.preparedStatement.setString(2, car.getRent());
		
		if(this.preparedStatement.executeUpdate()>0) {
			flag = true;
		}
		this.preparedStatement.close();
		return flag;

	}

	@Override
	public ArrayList<Car> findAll() throws Exception {

		ArrayList<Car> arr = new ArrayList<>();
		Car car = null;
		
		String sql = "SELECT * FROM car";
		this.preparedStatement = this.connection.prepareStatement(sql);
		
		ResultSet rs= this.preparedStatement.executeQuery();
		
		while( rs.next() ) {
			car = new Car();
			
			car.setCarid( rs.getInt(1) );
			car.setLicense( rs.getString(2) );
			car.setRent( rs.getString(3) );
			
			arr.add(car);
		}
		
		if ( arr.size() == 0 ) {
			arr = null;
		}
		
		this.preparedStatement.close();
		return arr;

	}

	@Override
	public Car findById(Car car) throws Exception {

		Car car2 = null;
		String sql="SELECT * FROM car WHERE carid=?";
		this.preparedStatement=this.connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, car.getCarid());
		
		ResultSet rs = this.preparedStatement.executeQuery();
		if(rs.next()){
			car2 = new Car();
			car2.setCarid( rs.getInt(1) );
			car2.setLicense( rs.getString(2) );
			car2.setRent( rs.getString(3) );
		}
		this.preparedStatement.close();
		return car2;

	}

	@Override
	public boolean deleteById(Car car) throws Exception {

		boolean flag = false;
		String sql = "DELETE FROM car WHERE carid=?";
		this.preparedStatement = this.connection.prepareStatement(sql);
		this.preparedStatement.setInt(1, car.getCarid());
		
		if(this.preparedStatement.executeUpdate()>0) {
			flag = true;
		}
		this.preparedStatement.close();
		return flag;

	}

	@Override
	public boolean doUpdata(Car car) throws Exception {

		boolean flag = false;
		
		String sql = "UPDATE car SET license=?,rent=? WHERE carid=?";
		
		this.preparedStatement = this.connection.prepareStatement(sql);
		this.preparedStatement.setString(1, car.getLicense());
		this.preparedStatement.setString(2, car.getRent());
		this.preparedStatement.setInt(3, car.getCarid());
		
		if(this.preparedStatement.executeUpdate()>0) {
			flag = true;
		}
		this.preparedStatement.close();
		return flag;

	}

}
