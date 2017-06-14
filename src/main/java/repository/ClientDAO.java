package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import entity.Client;
import entity.CourseSession;
import util.HibernateUtil;

public class ClientDAO {
	
	public Long addClient(Client client) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(System.out);
        } 
            session.close();
            return client.getID_Client();
        
        
    }

    public void deleteClient(Long clientId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Client client = (Client) session.load(Client.class, clientId);
            session.delete(client);
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

    public void updateClient(Client client) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(client);
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

public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<Client>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            clients = session.createQuery("from Client").list();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
            session.close();
        }
        return clients;
    }

    public Client getClientById(Long clientId) {
        Client client = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Client where id = :id";
            Query query = session.createQuery(queryString);
            query.setLong("id", clientId);
            client = (Client) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
           session.close();
        }
        return client;
    }
    
    public Client getClientByMail(String clientMail) {
        Client client = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Client where EMAIL = :mail";
            Query query = session.createQuery(queryString);
            query.setString("mail", clientMail);
            client = (Client) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace(System.out);
        } finally {
           session.close();
        }
        return client;
    }

}
