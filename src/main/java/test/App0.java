package test;

import java.util.List;

import org.hibernate.Session;

import entity.Course;
import service.CourseService;
import util.HibernateUtil;

public class App0 {
    
	   public static void main(String[] args)
	   {
	       Session session=HibernateUtil.getSessionFactory().openSession();
	       session.close();
		
	   }
	    
	}