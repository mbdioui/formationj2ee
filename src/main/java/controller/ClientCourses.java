package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Client;
import service.ClientService;
import entity.CourseSession;
import service.CourseSessionService;

@WebServlet(name = "ClientCourses", urlPatterns = {"/ClientCourses"})
public class ClientCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ClientCourses() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                CourseSessionService CourseSessionService = new CourseSessionService();
                int clientid=Integer.parseInt(request.getParameter("Client_ID"));
		List<CourseSession> CourseSessions = CourseSessionService.getCourseByClientId(clientid);
                System.out.println(CourseSessions.size());
                request.setAttribute("Client_ID", clientid);
                request.setAttribute("Courses", CourseSessions);
		this.getServletContext().getRequestDispatcher("/WEB-INF/ListClientCourses.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
