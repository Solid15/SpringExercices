package be.abis.exercise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SomeCourseServiceTest {

    @Qualifier("SomeService")
    @Autowired
    CourseService courseService;

    @Test
    public void testFindIdWith7900() {
        assertEquals("Test Course", courseService.findCourse(7900).getShortTitle());
    }

}