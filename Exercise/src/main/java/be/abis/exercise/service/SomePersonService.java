package be.abis.exercise.service;

import be.abis.exercise.model.Person;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
@Profile("dev")
public class SomePersonService implements PersonService {
    @Override
    public ArrayList<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person findPerson(int id) {
        return null;
    }

    @Override
    public Person findPerson(String emailAddress, String passWord) {
        Person person = new Person();
        person.setPersonId(7);
        person.setLanguage("NL");
        person.setEmailAddress(emailAddress);
        person.setPassword(passWord);
        person.setFirstName("Kim");
        person.setLastName("Wauters");
        person.setAge(38);
        return person;
    }

    @Override
    public void addPerson(Person p) throws IOException {

    }

    @Override
    public void deletePerson(int id) {

    }

    @Override
    public void changePassword(Person p, String newPswd) throws IOException {

    }
}
