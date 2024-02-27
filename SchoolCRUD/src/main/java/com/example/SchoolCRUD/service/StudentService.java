package com.example.SchoolCRUD.service;

import com.example.SchoolCRUD.domain.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();

    public Student getStudentsById(Long studentID);

    public void addNewStudent(Student student);

    public void deleteStudent(Long studentID);

    public Student updateStudent(Long studentID, Student student);
}
