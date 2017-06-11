package controller;

import entity.CourseSession;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CourseSessionService;

@WebServlet(name = "CourseSessionServlet", urlPatterns = {"/Coursesession"})
public class CourseSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CourseSessionServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
            CourseSessionService courseSessionService = new CourseSessionService();
            List<CourseSession> courseSessions = courseSessionService.getAllCourseSessions();
            request.setAttribute("CourseSession", courseSessions);
            this.getServletContext().getRequestDispatcher("/WEB-INF/ListCourseSession.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
