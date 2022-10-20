package be.abis.exercise.service;

import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AbisPersonServiceTest {

    @Autowired
    PersonService personService;

    @Test
    @Order(-3)
    public void findPerson1Test() {
        assertEquals("John", personService.findPerson(1).getFirstName());
    }

    @Test
    @Order(-2)
    public void findOracleGuyByEmailTest() {
        assertEquals("Bob", personService.findPerson("bob.smith@oracle.com", "abc986" ).getFirstName());
    }

    @Test
    @Order(0)
    public void findTotalNumberOfPeopleTest() {
        assertEquals(3, personService.getAllPersons().size());
    }

    @Test
    @Order(1)
    public void addNewPersonTest() throws IOException {
        Person person = new Person();
        person.setPersonId(4);
        person.setFirstName("Sail");
        person.setLastName("Away");
        person.setAge(36);
        person.setEmailAddress("alestorm@pirates.argh");
        person.setPassword("YourRum");
        person.setLanguage("English");

        Company company = new Company();
        company.setName("Pirate Bay");

        Address address = new Address();
        address.setTown("Tortuga");
        address.setStreet("Buccanneers' Bay");
        address.setNr(13);
        address.setZipcode("8000");

        company.setAddress(address);
        person.setCompany(company);

        personService.addPerson(person);
        assertEquals("alestorm@pirates.argh", personService.findPerson(4).getEmailAddress());
    }

    @Test
    @Order(2)
    public void passwordChangedTest() throws IOException {
        personService.changePassword(personService.findPerson(4), "BlackRoses");
        assertEquals("BlackRoses", personService.findPerson(4).getPassword());
    }

    @Test
    @Order(-1)
    public void deletePersonTest() {
        personService.deletePerson(4);
        assertEquals(3, personService.getAllPersons().size());
    }

}