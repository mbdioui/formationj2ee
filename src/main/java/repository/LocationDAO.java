package repository;

import entity.Location;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Jamal
 */
public class LocationDAO {
    public void addLocation(Location location) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(location);
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

    public void deleteLocation(Long locationId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Location location = (Location) session.load(Location.class, locationId);
            session.delete(location);
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

    public void updateLocation(Location location) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(location);
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

    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            locations = session.createQuery("from Location").list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return locations;
    }

    public Location getLocationById(Long locationId) {
        Location location = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Location where id = :id";
            Query query = session.createQuery(queryString);
            query.setLong("id", locationId);
            location = (Location) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return location;
    }
     public Location getLocationByCity(String city) {
        Location location = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Location where city= :city";
            Query query = session.createQuery(queryString);
            query.setString("city", city);
            location = (Location) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return location;
    }
}