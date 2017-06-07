package service;

import java.util.List;

import entity.Client;
import entity.CourseSession;
import repository.ClientDAO;

public class ClientService {

ClientDAO clientDao = new ClientDAO();
    
    public void addClient(Client client){
        clientDao.addClient(client);
    }
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }
    public Client getClientById(Long clientId) {
        return clientDao.getClientById(clientId);
    }
    public void addCourseSessionToClient(Client client, CourseSession courseSession)
    {
       clientDao.addCourseSessionToClient(client, courseSession);
    }
	
}
