package be.abis.exercise.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("dev")              // overrides the standard profile setting in application.properties
class SomePersonServiceTest {

    @Autowired
    PersonService personService;

    @Test
    public void testFindYourselfByEmail() {
        assertEquals("Kim", personService.findPerson("email", "pass").getFirstName());
    }

}