package com.example.SchoolCRUD;

import com.example.SchoolCRUD.domain.CourseInfo;
import com.example.SchoolCRUD.domain.Student;
import com.example.SchoolCRUD.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentDemo {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mari = new Student("jk.mari@gmail.com", "Mari", "Rouse",
                    CourseInfo.AF);

            Student thomas = new Student("thomas@gmail.com", "Thomas", "Shebly",
                    CourseInfo.BMF);

            Student Sadr = new Student("sadr@gmail.com", "Sadr", "Xudaybaxshev",
                    CourseInfo.EF);

            Student JK = new Student("jk.@gmail.com", "JK", "Khamro",
                    CourseInfo.CSF);

            repository.saveAll(List.of(mari, thomas, Sadr, JK));
        };
    }
}