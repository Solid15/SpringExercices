package be.abis.exercise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AbisCourseServiceTest {

    @Autowired
    @Qualifier("AbisService")
    private CourseService courseService;

    @Test
    public void findCourseWithId7900() {
        assertEquals("Workshop SQL", courseService.findCourse(7900).getLongTitle());
    }
}