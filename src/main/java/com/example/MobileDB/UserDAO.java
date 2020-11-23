package com.example.MobileDB;

import java.sql.SQLException;
import java.util.Set;

public interface UserDAO {
	
	User getUser(Integer id);
    Set<User> getAllUsers() throws SQLException;
    User getUserByUserNameAndPassword(String user, String pass);
    boolean insertUser(User user);
    
    boolean batchInsertUser();
    boolean updateUser(User user);
    boolean deleteUser(Integer id);
}
