package be.abis.exercise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
    public void findCourseWithId7900() {
        assertEquals("Workshop SQL", ((AbisTrainingService)trainerService)
                .getCourseService().findCourse(7900).getLongTitle());
    }



}