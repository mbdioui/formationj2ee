package test;

import org.hibernate.Session;

import tools.HibernateUtil;

public class App0 {
    
	   public static void main(String[] args)
	   {
	       Session session=HibernateUtil.getSessionFactory().openSession();
	   }
	    
	}