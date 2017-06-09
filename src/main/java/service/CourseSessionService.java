package service;

import entity.Course;
import entity.CourseSession;
import entity.Location;
import java.util.Date;
import java.util.List;
import repository.CourseSessionDAO;

public class CourseSessionService {
    CourseSessionDAO courseSessionDao = new CourseSessionDAO();

    public void addCourseSession(CourseSession courseSession) {
        courseSessionDao.addCourseSession(courseSession);
    }

    public List<CourseSession> getAllCourseSessions(){
        return courseSessionDao.getAllCourseSessions();
    }
    public CourseSession getCourseSessionById(Long courseSessionId) {
        return courseSessionDao.getCourseSessionById(courseSessionId);
    }
    public List<CourseSession> getCourseSessionsByDate(Date date){
        return courseSessionDao.getCourseSessionsByDate(date);
    }
    public List<CourseSession> getCourseSessionsByLocation(String location) {
        return courseSessionDao.getCourseSessionsByLocation(location);
    }
    public List<Course> getCourseByDate(Date date){
        return courseSessionDao.getCourseByDate(date);
    }
    public List<Course> getCourseByLocation(String location) {
        return courseSessionDao.getCourseByLocation(location);
    }
    public void addCourseToCourseSession(CourseSession courseSession, Course course) {
        courseSessionDao.addCourseToCourseSession(courseSession, course);
    }

    public void addLocationToCourseSession(CourseSession courseSession, Location location) {
        courseSessionDao.addLocationToCourseSession(courseSession, location);
    }
    
    public List<CourseSession> getCourseSessionsFilter(Date date, Long loc, String title) {
       return courseSessionDao.getCourseSessionsFilter(date, loc, title);
    }
}
