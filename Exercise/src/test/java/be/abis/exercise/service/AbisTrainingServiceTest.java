package be.abis.exercise.service;

import be.abis.exercise.exceptions.EnrollException;
import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AbisTrainingServiceTest {

    @Autowired
    private TrainingService trainerService;

    @Test
    public void findPerson1Test() {
        assertEquals("John", ((AbisTrainingService)trainerService)
                .getPersonService().findPerson(1).getFirstName());
    }

    @Test
    public void findCourseWithId7900Test() {
        assertEquals("Workshop SQL", ((AbisTrainingService)trainerService)
                .getCourseService().findCourse(7900).getLongTitle());
    }

    @Test
    public void enrollmentThrowsExceptionTest() {
        Person person = new Person();           // TODO call student from memory/file
        Course course = new Course();
        LocalDate date = LocalDate.now().minusDays(1);      // boundary testing
        assertThrows(EnrollException.class, () -> trainerService.enrollForSession(person, course, date));
    }

    @Test
    public void doesNotThrowEnrollmentExceptionTest() {
        Person person = new Person();        // TODO call student from memory/file
        Course course = new Course();
        LocalDate date = LocalDate.now();               // boundary testing
        assertDoesNotThrow(() -> trainerService.enrollForSession(person, course, date));
    }



}