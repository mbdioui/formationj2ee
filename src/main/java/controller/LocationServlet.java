package controller;

import static controller.ClientCourses.logger;
import entity.Location;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import service.LocationService;

@WebServlet(name = "LocationSevlet", urlPatterns = {"/Location"})
public class LocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        final static Logger logger = Logger.getLogger(LocationServlet.class);

        public LocationServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            LocationService locationservice = new LocationService();
            List<Location> locations = locationservice.getAllLocations();
            logger.info("locations :"+locations);
            request.setAttribute("Locations", locations);
            this.getServletContext().getRequestDispatcher("/WEB-INF/ListLocation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
