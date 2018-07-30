package com.niit.jdbcwebcrud.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.jdbccrud.dao.UserDAO;
import com.niit.jdbccrud.daoimpl.UserDAOImpl;
import com.niit.jdbccrud.model.User;

@WebServlet("/")
public class BaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher dispatcher;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		switch (path) 
		{
		case "/":	      dispatcher=request.getRequestDispatcher("WEB-INF/views/index.jsp");
		  				  dispatcher.forward(request, response);
		                  break;
		case "/loginPage":dispatcher=request.getRequestDispatcher("WEB-INF/views/loginPage.jsp");
						  dispatcher.forward(request, response);
						  break;
		case "/registerPage":dispatcher=request.getRequestDispatcher("WEB-INF/views/registerPage.jsp");
		  				  dispatcher.forward(request, response);
		  				  break;
		case "/register": createUser(request,response);
						  break;
		case "/login":    loginUser(request,response);
		  				  break;
		case "/logout":   dispatcher=request.getRequestDispatcher("WEB-INF/views/index.jsp");
		  				  dispatcher.forward(request, response);
		  				  break;
		case "/edit":  	  editUser(request,response);
						  break;
						  
		case "/update":   updateUser(request,response);
		  				  break;
		  				  
		case "/delete":    deleteUser(request, response);
		  				  break;
		case "/getall":	  getAllUsers(request,response);
						  break;
		default:
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public void createUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String password=request.getParameter("password");
		UserDAO userDAO=new UserDAOImpl();
		
		User user=new User();
		user.setId(id);
		user.setFname(fname);
		user.setLname(lname);
		user.setPassword(password);
		userDAO.createUser(user);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/profile.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
		
	}
	public void loginUser(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		String fname=request.getParameter("fname");
		String password=request.getParameter("password");
		UserDAO userDAO=new UserDAOImpl();
		
		User user=userDAO.loginUser(fname,password);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/profile.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
		
	}

	public void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String password=request.getParameter("password");
		UserDAO userDAO=new UserDAOImpl();
		
		User user=new User();
		user.setId(id);
		user.setFname(fname);
		user.setLname(lname);
		user.setPassword(password);
		userDAO.updateUser(user);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/profile.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
		
	}
	
	public void editUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		UserDAO userDAO=new UserDAOImpl();
		User user=userDAO.getUserById(id);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/edit.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);
		
	}
	
	public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		  int id=Integer.parseInt(request.getParameter("id"));
		  UserDAO userDAO=new UserDAOImpl();
		  User user=userDAO.getUserById(id);
		  userDAO.deleteUser(user);
		  getAllUsers(request, response);
	}
	
	private void getAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/views/list.jsp");
		  UserDAO userDAO=new UserDAOImpl();
		  List<User> list=userDAO.getUserList();
		  request.setAttribute("list", list);
		  dispatcher.forward(request, response);
		
	}
	

}
