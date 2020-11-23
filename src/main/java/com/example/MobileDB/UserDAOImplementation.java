package com.example.MobileDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImplementation implements UserDAO {

	public User getUser(Integer id) {
		Connection connection = JDBCConfig.getConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM public.user WHERE id=" + id);
			if (rs.next()) {
				return extractUserFromResultSet(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public Set getAllUsers() throws SQLException {
//		Connection connection = JDBCConfig.getConnection();
		
		HikariCPConfig config =  new HikariCPConfig();
		Connection connection = HikariCPConfig.getConnection();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM public.users;");
			Set users = new HashSet();
			while (rs.next()) {
				User user = extractUserFromResultSet(rs);
				users.add(user);
			}
			return users;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public User getUserByUserNameAndPassword(String user, String pass) {
		Connection connection = JDBCConfig.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM public.user WHERE user=? AND pass=?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return extractUserFromResultSet(rs);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public boolean insertUser(User user) {
	    Connection connection = JDBCConfig.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("INSERT INTO public.user VALUES (NULL, ?, ?, ?)");
	        ps.setInt(1, user.getUser_id());
	        ps.setString(2, user.getName());
	        ps.setString(3, user.getEmail());
	        ps.setString(3, user.getCountry());
	        ps.setString(3, user.getPassword());
	        int i = ps.executeUpdate();
	      if(i == 1) {
	        return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

	public boolean updateUser(User user) {
	    Connection connection = JDBCConfig.getConnection();
	    try {
	        PreparedStatement ps = connection.prepareStatement("UPDATE public.user SET name=?, pass=?, age=? WHERE id=?");
	        ps.setInt(1, user.getUser_id());
	        ps.setString(2, user.getName());
	        ps.setString(3, user.getEmail());
	        ps.setString(4, user.getCountry());
	        ps.setString(4, user.getPassword());
	        int i = ps.executeUpdate();
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

	public boolean deleteUser(Integer id) {
	    Connection connection = JDBCConfig.getConnection();
	    try {
	        Statement stmt = connection.createStatement();
	        int i = stmt.executeUpdate("DELETE FROM public.user WHERE id=" + id);
	      if(i == 1) {
	    return true;
	      }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	    return false;
	}

	private User extractUserFromResultSet(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUser_id(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setCountry(rs.getString("country"));
		user.setPassword(rs.getString("password"));
		return user;
	}

	public boolean batchInsertUser() {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
