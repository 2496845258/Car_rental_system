package com.vo;

public class User {
	private int userid;// �û����
	private String account; // �˺�
	private String passwor; // ����
	private String username; // �û�����
	private String telephone; // �绰
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswor() {
		return passwor;
	}
	public void setPasswor(String passwor) {
		this.passwor = passwor;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
