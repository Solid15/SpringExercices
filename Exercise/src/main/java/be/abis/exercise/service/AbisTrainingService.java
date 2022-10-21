package be.abis.exercise.service;

import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;

public class AbisTrainingService implements TrainingService {

    @Value("Welcome student!")
    private String welcomeMessage;
    private String helloMessage;
    private PersonService personService;
    private CourseService courseService;

    public AbisTrainingService() {
    }

    public AbisTrainingService(PersonService personService, CourseService courseService) {
        this.personService = personService;
        this.courseService = courseService;
    }

    @Override
    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    @Override
    public List<Course> showFollowedCourses(Person person) {
        return null;
    }

    @Override
    public void enrollForSession(Person person, Course course, LocalDate date) throws EnrollException {

    }

    @Override
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public CourseService getCourseService() {
        return courseService;
    }
}
