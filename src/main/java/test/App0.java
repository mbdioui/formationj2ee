package test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import entity.Client;
import entity.Course;
import service.CourseService;
import util.HibernateUtil;

public class App0 {
    
	   public static void main(String[] args)
	   {
	       Session session=HibernateUtil.getSessionFactory().openSession();
	       CourseService service = new CourseService();
	       List<Course> courses=service.getAllCourses();
	       for (Course course : courses) {
			System.out.print(course.toString()+'\n');
	       }
	   }
	    
	}