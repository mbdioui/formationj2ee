package service;

import java.util.List;

import entity.Course;
import repository.CourseDAO;

public class CourseService {
	
	CourseDAO courseDao = new CourseDAO();

    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    public Course getCourseById(Long courseId) {
        return courseDao.getCourseById(courseId);
    }

    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    public List<Course> getCourseByTitle(String courseTitle) {
        return courseDao.getCourseByTitle(courseTitle);
    }

}
