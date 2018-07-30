package com.niit.jdbccrud.dao;

import java.util.List;

import com.niit.jdbccrud.model.User;


public interface UserDAO {
	
	public List<User> getUserList();
	
	public boolean createUser(User user);
	
	public User getUserById(int userId);
	
	public User loginUser(String fname,String password);
	
	public boolean updateUser(User user);
	
	public boolean deleteUser(User user);

}
