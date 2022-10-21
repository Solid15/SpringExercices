package be.abis.exercise;

import be.abis.exercise.service.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class ExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseApplication.class, args);
    }


    @Bean
    public TrainingService trainingService(PersonService personService,  @Qualifier("AbisService") CourseService courseService) {
        return new AbisTrainingService(personService, courseService);
    }


}
