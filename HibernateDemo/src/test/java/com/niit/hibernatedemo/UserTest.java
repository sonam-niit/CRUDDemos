package com.niit.hibernatedemo;

import com.niit.hibernatedemo.dao.UserDAO;
import com.niit.hibernatedemo.daoimpl.UserDAOImpl;
import com.niit.hibernatedemo.model.User;

import junit.framework.TestCase;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


public class UserTest{

	UserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		userDAO = new UserDAOImpl();
	}

	@After
	public void tearDown() throws Exception {
		userDAO = null;
	}
	
	@Ignore
	@Test
	public void addUser() {
		User user = new User();
		user.setFname("sonam");
		user.setLname("soni");
		user.setPassword("12345");

		assertEquals(true, userDAO.createUser(user));
	}
	
	@Test
	public void userList() {

		List<User> getUserList = userDAO.getUserList();
		for (User user : getUserList) {
			System.out.println("Name: " + user.getFname());
		}
		
		assertEquals(3, getUserList.size());
	}

	@Test
	public void testupdateUser() {
		User user = userDAO.getUserById(2);
		user.setLname("patel");
		assertEquals(true, userDAO.updateUser(user));
	}

	@Test
	public void deleteUser() {
		User user = userDAO.getUserById(3);
		System.out.println(user.getFname());
		assertEquals(true, userDAO.deleteUser(user));
	}

}
