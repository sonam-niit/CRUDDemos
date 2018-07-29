package com.niit.hibernatedemo.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.niit.hibernatedemo.model.User;

public class DBConfig {

	   public static SessionFactory getSessionFactory(){
		   SessionFactory sessionFactory;
		   try
			  {
				    Configuration configuration = new Configuration();
			        configuration.configure("hibernate.cfg.xml");
			        configuration.addAnnotatedClass(User.class);
			        ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			        sessionFactory=configuration.buildSessionFactory(srvcReg);
			  }
			  catch(Throwable th){
			   System.err.println("Enitial SessionFactory creation failed"+th);
			   throw new ExceptionInInitializerError(th);
			  }
		   
		   return sessionFactory;
	   }

	
}
