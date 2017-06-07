package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import service.CourseService;

@WebServlet(name = "AcceuilServlet", urlPatterns = {"/Acceuil"})
public class AcceuilServlet extends HttpServlet {
 
    public AcceuilServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CourseService courseService = new CourseService();
        List <Course> courses = courseService.getAllCourses();	       
        request.setAttribute("Courses", courses);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Acceuil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}