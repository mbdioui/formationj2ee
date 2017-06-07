package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Course;
import util.HibernateUtil;

public class CourseDAO {
	
	public void addCourse(Course course) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
    }

    public void deleteCourse(Long courseId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Course course = (Course) session.load(Course.class, courseId);
            session.delete(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
    }

    public void updateCourse(Course course) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
    }

    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<Course>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            courses = session.createQuery("from Course").list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return courses;
    }

    public Course getCourseById(Long courseId) {
        Course course = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Course where id = :id";
            Query query = session.createQuery(queryString);
            query.setLong("id", courseId);
            course = (Course) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return course;
    }

    public List<Course> getCourseByTitle(String courseTitle) {
        List<Course> courses = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Course where title = :title";
            Query query = session.createQuery(queryString);
            query.setString("title", "%" + courseTitle + "%");
            courses = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return courses;
    }

}
