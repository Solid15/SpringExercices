package be.abis.exercise.service;

import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

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
        if (date.isBefore(LocalDate.now())) throw new EnrollException("No inscription in the past possible");
        System.out.println(person.getFirstName() + " is now enrolled for the " + course.getShortTitle()
                + " course on " + date);
    }                                                   // DAYS.between(date, LocalDate.now()) < 0

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
