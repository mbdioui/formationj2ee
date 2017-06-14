/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author mohamed salah
 */

import entity.Client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.ClientService;
import service.CourseSessionService;

@WebServlet(name = "Subscription", urlPatterns = {"/Subscription"})
public class SubscriptionCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SubscriptionCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //geting parameters from Inscription page
            String idcoursesession= request.getParameter("course_no");
            String FirstName=request.getParameter("FirstName");
            String LastName=request.getParameter("LastName");
            String address=request.getParameter("address");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            //inserting client
            ClientService clientService=new ClientService();
            Client c= new Client(FirstName,LastName,address,phone,email);
            Long id_client;
            if (clientService.getClientByMail(email)==null)
            {
                id_client=clientService.addClient(c);
            }
            else{
                id_client=clientService.getClientByMail(email).getID_Client();
                c.setID_Client(id_client);
            }
            //affecting this client to the selected course
            CourseSessionService courseservice= new CourseSessionService();
            courseservice.addClientToCourseSession(Integer.parseInt(idcoursesession),c);
            //redirecting to the final subsribtion page
            this.getServletContext().getRequestDispatcher("/WEB-INF/subscriptiondone.jsp").forward(request, response);
//            SendHTMLEmail.main();
        }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

