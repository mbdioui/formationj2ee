package repository;

import java.util.ArrayList;
import entity.Course;
import entity.CourseSession;
import entity.Location;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Hamza
 */
public class CourseSessionDAO {

    public void addCourseSession(CourseSession courseSession) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(courseSession);
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

    public void deleteCourseSession(Long courseSessionId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            CourseSession courseSession = (CourseSession) session.load(CourseSession.class, courseSessionId);
            session.delete(courseSession);
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

    public void updateCourseSession(CourseSession courseSession) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(courseSession);
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

    public List<CourseSession> getAllCourseSessions() {
        List<CourseSession> courseSessions = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            courseSessions = session.createQuery("from CourseSession").list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return courseSessions;
    }

    public CourseSession getCourseSessionById(Long courseSessionId) {
        CourseSession courseSession = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from CourseSession where id = :id";
            Query query = session.createQuery(queryString);
            query.setLong("id", courseSessionId);
            courseSession = (CourseSession) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return courseSession;
    }

    public List<CourseSession> getCourseSessionsByDate(Date date) {
        List<CourseSession> courses = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Query query = session.createQuery("from CourseSession where startDate <= :date_1 and finDate >= :date_2");
            query.setDate("date_1", date);
            query.setDate("date_2", date);
            courses = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return courses;
    }

    public List<CourseSession> getCourseSessionsByLocation(String location) {
        List<CourseSession> courses = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Query query = session.createQuery("from CourseSession c where c.location.city= :location");
            query.setString("location", location);
            courses = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return courses;
    }

    public List<Course> getCourseByDate(Date date) {
        List<Course> courses = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Query query = session.createQuery("select course from CourseSession where startDate <= :date_1 and finDate >= :date_2");
            query.setDate("date_1", date);
            query.setDate("date_2", date);
            courses = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return courses;
    }

    public List<Course> getCourseByLocation(String location) {
        List<Course> courses = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Query query = session.createQuery("select course from CourseSession c where c.location.city= :location");
            query.setString("location", location);
            courses = query.list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return courses;
    }

    public void addCourseToCourseSession(CourseSession courseSession, Course course) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            CourseSession MyCourseSession = this.getCourseSessionById(courseSession.getSessionId());
            MyCourseSession.setCourse(course);
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

    public void addLocationToCourseSession(CourseSession courseSession, Location location) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            CourseSession MyCourseSession = this.getCourseSessionById(courseSession.getSessionId());
            MyCourseSession.setLocation(location);
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

    public List<CourseSession> getCourseSessionsFilter(Date date, Long loc, String title) {
        System.out.println(date + " " + loc + " " + title);

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CourseSession> courseSessions = null;

        try {
            session.beginTransaction();
            
            Criteria criteria = session.createCriteria(CourseSession.class, "cs");
            criteria.createCriteria("course", "c").add(Restrictions.like("c.title", title, MatchMode.ANYWHERE));
            if (date != null) {
                criteria.add(Restrictions.le("cs.startDate", date));
                criteria.add(Restrictions.ge("cs.finDate", date));
            }
            if (loc != null) {
                criteria.createAlias("location", "l");
                criteria.add(Restrictions.eq("l.id", loc));
            }
            courseSessions = criteria.list();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
            if (session.getTransaction() != null) {
                try {
                    session.getTransaction().rollback();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (HibernateException he2) {
                    he2.printStackTrace();
                }
            }
        }
        for (CourseSession c : courseSessions) {
            System.out.println(c.getCourse().getCODE());
        }
        return courseSessions;
    }
}
