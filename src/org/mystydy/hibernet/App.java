package org.mystydy.hibernet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.mystydy.hibernet.entity.Users;


public class App {
	
 public static void main(String[] args) {
	SessionFactory factory =  new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Users.class)
								.buildSessionFactory();
	Session session = factory.getCurrentSession();
	
	
	try {
		//addRecordsToDB(factory,session);
		retrieveRecordsFromDB(factory,session);
	} catch (Exception e) {
		// TODO: handle exception
	}
	finally {
		session.close();
		factory.close();
	}
}
  public static void addRecordsToDB( SessionFactory factory,Session session) {
	  try {
			//create object of entity class type
			Users user = new Users("username", "password", "firstName", "lastName");
			
			//Start transaction
			session.beginTransaction();
		
			//perform operation
			session.save(user);
			//commit the transaction
			
			session.getTransaction().commit();
			System.out.println("Row Added");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

		}
  }
  public static void retrieveRecordsFromDB( SessionFactory factory,Session session) {
	  System.out.println("retrieving records fron database");
	  try {
			//create object of entity class type
			Users user = new Users();
			
			//Start transaction
			session.beginTransaction();
		
			//perform operation
			user = session.get(Users.class,2);
			
			//commit the transaction
			
			session.getTransaction().commit();

			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {

		}
  }
}
