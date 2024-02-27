package com.example.SchoolCRUD.domain;

import lombok.Getter;

@Getter
public enum CourseInfo {
    CSF(1500.000, 4.5), // COMPUTER SCIENCE FACULTY
    EF(1200.000, 4.5), // ENGINEERING FACULTY
    AF(1000.000, 3.0), // ARCHITECTURE FACULTY
    IRF(900.000, 4.0), // INTERNATIONAL RELATIONS FACULTY
    BMF (900.000, 4.0)// BUSINESS MANAGEMENT FACULTY
    ;
    private final double price;
    private final double durationOfCourse;
    CourseInfo(Double price, Double duration) {
        this.price = price;
        this.durationOfCourse = duration;
    }

}
