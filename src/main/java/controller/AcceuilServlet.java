package controller;

import static controller.CourseSessionServlet.logger;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Course;
import org.apache.log4j.Logger;
import service.CourseService;

@WebServlet(name = "AcceuilServlet", urlPatterns = {"/Acceuil"})
public class AcceuilServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(AcceuilServlet.class);

    public AcceuilServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CourseService courseService = new CourseService();
        List<Course> courses = courseService.getAllCourses();
        logger.info("number courses retreived :"+courses.size());
        request.setAttribute("Courses", courses);
        this.getServletContext().getRequestDispatcher("/WEB-INF/Acceuil.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(request, response);
    }

}
