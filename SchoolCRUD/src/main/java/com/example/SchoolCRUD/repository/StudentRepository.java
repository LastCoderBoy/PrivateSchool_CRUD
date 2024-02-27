package com.example.SchoolCRUD.repository;

import com.example.SchoolCRUD.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentById (Long Id);
    Optional<Student> findStudentsByEmail(String email);
}
