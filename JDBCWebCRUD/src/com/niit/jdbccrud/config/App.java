package com.niit.jdbccrud.config;

import java.util.List;

import com.niit.jdbccrud.dao.UserDAO;
import com.niit.jdbccrud.daoimpl.UserDAOImpl;
import com.niit.jdbccrud.model.User;

public class App {

	public static void main(String[] args) {
	
		UserDAO userDAO=new UserDAOImpl();
		
		//Create User
	
		/*User user=new User();
		user.setId(2);
		user.setFname("Pooja");
		user.setLname("devi");
		user.setPassword("1234");
		
		
		if(userDAO.createUser(user))
			System.out.println("User Added Successfully");*/
		
		//Update User
		/*User user=new User();
		user.setId(1);
		user.setFname("Sonam");
		user.setLname("soni");
		user.setPassword("Son123");
		
		if(userDAO.updateUser(user))
			System.out.println("User Updated Successfully");*/
		
		//Get All User
		List<User> list=userDAO.getUserList();
		for(User user1:list)
		{
			System.out.println(user1.getId()+" "+user1.getFname()+" "+user1.getLname()+" "+user1.getPassword());
		}
		
		//Delete User
		/*User user=new User();
		user.setId(1);
		if(userDAO.deleteUser(user))
		{
			System.out.println("User deleted Successfully");
		}*/
		
		//Get All User
		User user1=userDAO.getUserById(2);
			System.out.println(user1.getId()+" "+user1.getFname()+" "+user1.getLname()+" "+user1.getPassword());
		
	}
}
