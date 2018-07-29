package com.niit.hibernatedemo.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.hibernatedemo.config.DBConfig;
import com.niit.hibernatedemo.dao.UserDAO;
import com.niit.hibernatedemo.model.User;

public class UserDAOImpl implements UserDAO{
	
	private SessionFactory sessionFactory;
	
	public UserDAOImpl() {
		this.sessionFactory=DBConfig.getSessionFactory();
	}
	
	//Session session = DBConfig.getSession();
	public List<User> getUserList() {
		
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		 
		@SuppressWarnings("unchecked")
		List<User> getUserList = session.createQuery("from User").list();
		transaction.commit();
		return getUserList;
	}

	public boolean createUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.save(user);
		transaction.commit();
		System.out.println("test");
		return true;
	}
	
	public boolean updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.update(user);
		transaction.commit();
		return true;
	}
	
	public User getUserById(int userId) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		User user = (User) session.createQuery("from User where id = " + userId).list().get(0);
		transaction.commit();
		return user;
	}

	public boolean deleteUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		Transaction transaction=session.beginTransaction();
		session.delete(user);
		transaction.commit();
		return true;
	}
	
}
