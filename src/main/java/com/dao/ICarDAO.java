package com.dao;

import java.util.ArrayList;

import com.vo.Car;

public interface ICarDAO {
	public boolean doInsert(Car car) throws Exception;
	public ArrayList<Car> findAll() throws Exception;
	public Car findById( Car car ) throws Exception;
	public boolean deleteById( Car car ) throws Exception;
	public boolean doUpdata( Car car ) throws Exception;
}
