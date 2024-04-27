package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainTest {

	public static void main(String[] args) {
	/*	  Configuration cfg = new Configuration(); 
		  cfg.configure("hibernate.cfg.xml"); 
		  SessionFactory factory=cfg.buildSessionFactory(); 
		  Session session=factory.openSession();
		  Transaction tr=session.beginTransaction();
		  
		  //set data 
		  Student s1=new Student();
		  
		  s1.setId(1); 
		  s1.setName("Sohel"); 
		  s1.setAddress("Islampur");
		  s1.setSalary(5000);
		  
		  session.save(s1);
		  
		  tr.commit(); 
		  session.close();
		  factory.close();
		  System.out.println("Record inserted sucessfully..");*/
		 

		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();

		// Sesssion level cache:
		
		  Session session=factory.openSession();    
		  
		  Student st1=session.get(Student.class, 1); System.out.println(st1);	//[Query hit*]
		  
		  Student st2=session.get(Student.class, 1); System.out.println(st2);
		  
		  session.close();
		  
		  Session session2=factory.openSession();	
		  
		  Student st3=session2.get(Student.class, 1); System.out.println(st3);	//[Query hit*]
		  
		  session.close();
		 

//		Configuration cfg = new Configuration();
//		cfg.configure();
//		SessionFactory factory = cfg.buildSessionFactory();
//
//		// Sesssion Factory level cache:
//		
//		  Session session=factory.openSession();
//		  
//		  Student st1=session.get(Student.class, 1); System.out.println(st1);	//[Query hit*]
//		  
//		  session.close();
//		  
//		  Session session2=factory.openSession();
//		  
//		  Student st2=session2.get(Student.class, 1); System.out.println(st2);	
//		  
//		  session2.close();
		 

	}

}
