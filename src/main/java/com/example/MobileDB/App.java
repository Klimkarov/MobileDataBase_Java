package com.example.MobileDB;

import java.sql.SQLException;
import java.util.Set;

public class App {

	public static void main(String[] args) throws SQLException {

		UserDAO dao = new UserDAOImplementation();
		
//		User user = new User(123, "Dimitar", "password", 29);
//
//		dao.insertUser(user);

		Set<User> users = dao.getAllUsers();
		
		for (User user : users) {
			System.out.println(user.getName());
			
		}

	
	}

}
