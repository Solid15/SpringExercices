package be.abis.exercise;

import be.abis.exercise.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class, args);
    }


    @Bean
    public TrainingService trainingService(PersonService personService, CourseService courseService) {
        AbisTrainerService trainingService = new AbisTrainerService();
        trainingService.setPersonService(personService);
        trainingService.setCourseService(courseService);
        return trainingService;
    }


}
