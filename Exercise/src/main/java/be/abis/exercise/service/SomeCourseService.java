package be.abis.exercise.service;

import be.abis.exercise.model.Course;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("SomeService")
public class SomeCourseService implements CourseService {

    @Override
    public List<Course> findAllCourses() {
        return null;
    }

    @Override
    public Course findCourse(int id) {
        Course course = new Course();
        if (id == 7900) {
            course.setCourseId("7900");
            course.setLongTitle("Test Course");
            course.setShortTitle("Test Course");
            return course;
        } else return null;
    }

    @Override
    public Course findCourse(String shortTitle) {
        return null;
    }

    @Override
    public void addCourse(Course course) {

    }

    @Override
    public void updateCourse(Course course) {

    }

    @Override
    public void deleteCourse(Course course) {

    }
}
