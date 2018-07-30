package com.niit.jdbccrud.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.jdbccrud.config.DBConfig;
import com.niit.jdbccrud.dao.UserDAO;
import com.niit.jdbccrud.model.User;

public class UserDAOImpl implements UserDAO{

	Connection connection=null;
	public UserDAOImpl() {
		connection=DBConfig.getConnection();
	}
	@Override
	public List<User> getUserList() {
		try {
			PreparedStatement statement=connection.prepareStatement("select * from userjdbc");
			List<User> list=new ArrayList<>();
			
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				User user =new User();
				user.setId(resultSet.getInt(1));
				user.setFname(resultSet.getString(2));
				user.setLname(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
				list.add(user);
			}
			
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean createUser(User user) {
		try {
			PreparedStatement statement=connection.prepareStatement("insert into userjdbc (id,fname,lname,password) values(?,?,?,?)");
			statement.setInt(1, user.getId());
			statement.setString(2, user.getFname());
			statement.setString(3, user.getLname());
			statement.setString(4, user.getPassword());
			
			int i=statement.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public User getUserById(int userId) {
		try {
			PreparedStatement statement=connection.prepareStatement("select * from userjdbc where id=?");
	
			statement.setInt(1, userId);
			User user =new User();
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				user.setId(resultSet.getInt(1));
				user.setFname(resultSet.getString(2));
				user.setLname(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
			}
			
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			PreparedStatement statement=connection.prepareStatement("update userjdbc set fname=?,lname=?,password=? where id=?");
	
			statement.setString(1, user.getFname());
			statement.setString(2, user.getLname());
			statement.setString(3, user.getPassword());
			statement.setInt(4, user.getId());
			
			int i=statement.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteUser(User user) {
		try {
			PreparedStatement statement=connection.prepareStatement("delete from userjdbc where id=?");
	
			statement.setInt(1, user.getId());
			
			int i=statement.executeUpdate();
			if(i>0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public User loginUser(String fname, String password) {
		try {
			PreparedStatement statement=connection.prepareStatement("select * from userjdbc where fname=? and password=?");
	
			statement.setString(1, fname);
			statement.setString(2, password);
			User user =new User();
			ResultSet resultSet=statement.executeQuery();
			while(resultSet.next())
			{
				user.setId(resultSet.getInt(1));
				user.setFname(resultSet.getString(2));
				user.setLname(resultSet.getString(3));
				user.setPassword(resultSet.getString(4));
			}
			
			return user;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
