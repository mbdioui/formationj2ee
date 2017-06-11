package test;

import entity.Client;
import java.util.List;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import entity.Course;
import entity.CourseSession;
import entity.Location;
import java.util.Date;
import service.ClientService;
import service.CourseService;
import service.CourseSessionService;
import service.LocationService;
import entity.Client;
import entity.Course;
import service.CourseService;
import util.HibernateUtil;

public class App0 {
    
	   public static void main(String[] args)
	   {
	ClientService cs = new ClientService();
        CourseService courseService = new CourseService();
        CourseSessionService css = new CourseSessionService();
        LocationService locationService = new LocationService();

        /* Client c1 = new Client("hamza", "maatougui", "belfort", "296512", "hm@ubtm.fr");
              Client c2 = new Client("Fathellah", "Tahiri", "belfort", "29651254", "ft@ubtm.fr");
              Client c3 = new Client("francois", "Crimplet", "montbeliard", "0548751615", "fc@ubtm.fr");
              Client c4 = new Client("xavier", "jean", "marseille", "29654512", "xj@ubtm.fr");
              
              Course course1 = new Course("LO54", "JavaEE");
              Course course2 = new Course("BD50", "Conception de BDD");
              Course course3 = new Course("TO52", "Projet de developpement");
              Course course4 = new Course("LO43", "Orientée objet");
              Course course5 = new Course("LS00", "Espagnol niveau debutant");
              
              Location location1 = new Location("Belfort");
              Location location2 = new Location("Montbeliard");
              Location location3 = new Location("Sevenans");
              
              CourseSession cs1 = new CourseSession(new Date(2017, 03, 1), new Date(2017, 06, 31), course1, location1);
              CourseSession cs2 = new CourseSession(new Date(2017, 03, 1), new Date(2017, 06, 31), course2, location2);
              CourseSession cs3 = new CourseSession(new Date(2017, 03, 1), new Date(2017, 06, 31), course3, location1);
              CourseSession cs4 = new CourseSession(new Date(2017, 03, 1), new Date(2017, 06, 31), course1, location2);
              CourseSession cs5 = new CourseSession(new Date(2017, 11, 12), new Date(2018, 06, 31), course5, location2);
              CourseSession cs6 = new CourseSession(new Date(2017, 11, 12), new Date(2018, 06, 31), course5, location3);
              CourseSession cs7 = new CourseSession(new Date(2017, 10, 10), new Date(2017, 06, 31), course1, location2);
              CourseSession cs8 = new CourseSession(new Date(2016, 10, 10), new Date(2017, 06, 31), course4, location1);
              
              
              cs.addClient(c1);
              cs.addClient(c2);
              cs.addClient(c3);
              cs.addClient(c4);
              
              courseService.addCourse(course1);
              courseService.addCourse(course2);
              courseService.addCourse(course3);
              courseService.addCourse(course4);
              courseService.addCourse(course5);
              
              locationService.addLocation(location1);
              locationService.addLocation(location2);
              locationService.addLocation(location3);
              
              css.addCourseSession(cs1);
              css.addCourseSession(cs2);
              css.addCourseSession(cs3);
              css.addCourseSession(cs4);
              css.addCourseSession(cs5);
              css.addCourseSession(cs6);
              css.addCourseSession(cs7);
              css.addCourseSession(cs8);
              
              cs.addCourseSessionToClient(c1, cs2);
              cs.addCourseSessionToClient(c2, cs5);
              cs.addCourseSessionToClient(c3, cs8);
              cs.addCourseSessionToClient(c4, cs2);
               */
	
	       Session session=HibernateUtil.getSessionFactory().openSession();
	       CourseService service = new CourseService();
	       List<Course> courses=service.getAllCourses();
	       for (Course course : courses) {
			System.out.print(course.toString()+'\n');
	       }
	   }
	    
	}
