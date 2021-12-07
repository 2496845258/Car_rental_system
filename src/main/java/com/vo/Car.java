package com.vo;

public class Car {
	private int carid ; //³µÁ¾±àºÅ
	private String license; //³µÅÆ
	private String rent; //×â½ð
	
	public String getRent() {
		return rent;
	}
	public void setRent(String rent) {
		this.rent = rent;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
}
