package com.example.SchoolCRUD.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Student_Information")
public class Student {

    @GeneratedValue
    @Id
    private Long Id;
    private String email;
    private String name;
    private String surname;
    private String course;
    private Double durationOfCourse;
    private Double coursePrice;

    public Student(Long id, String email, String name, String surname, CourseInfo course, Double durationOfCourse, Double coursePrice) {
        Id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.course = course.name();
        this.durationOfCourse = durationOfCourse;
        this.coursePrice = coursePrice;
    }

    public Student(String email, String name, String surname, CourseInfo course) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.course = course.name();
        this.durationOfCourse = course.getDurationOfCourse();
        this.coursePrice = course.getPrice();
    }
}
