package com.example.MobileDB;

public class User {
	private Integer user_id;
	private String name;
	private String email;
	private String country;
	private String password;

	

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(Integer user_id, String name, String email, String country, String password) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.password = password;
	}

	public User(int i, String string, String string2, int j) {
		// TODO Auto-generated constructor stub
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	

}