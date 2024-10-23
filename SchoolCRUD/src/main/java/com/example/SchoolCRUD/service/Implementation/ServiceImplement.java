package com.example.SchoolCRUD.service.Implementation;

import com.example.SchoolCRUD.domain.CourseInfo;
import com.example.SchoolCRUD.domain.Student;
import com.example.SchoolCRUD.repository.StudentRepository;
import com.example.SchoolCRUD.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceImplement implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentsById(Long studentID) {
        return studentRepository.findStudentById(studentID);
    }

    @Override
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email is taken");
        }
        switch (student.getCourse()){
            case "AF":
                student.setCoursePrice(CourseInfo.AF.getPrice());
                student.setDurationOfCourse(CourseInfo.AF.getDurationOfCourse());
                break;
            case "CSF":
                student.setCoursePrice(CourseInfo.CSF.getPrice());
                student.setDurationOfCourse(CourseInfo.CSF.getDurationOfCourse());
                break;
            case "EF":
                student.setCoursePrice(CourseInfo.EF.getPrice());
                student.setDurationOfCourse(CourseInfo.EF.getDurationOfCourse());
                break;
            case "IRF":
                student.setCoursePrice(CourseInfo.IRF.getPrice());
                student.setDurationOfCourse(CourseInfo.IRF.getDurationOfCourse());
                break;
            case "BMF":
                student.setCoursePrice(CourseInfo.BMF.getPrice());
                student.setDurationOfCourse(CourseInfo.BMF.getDurationOfCourse());
                break;
        }
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentID) {
        boolean exists = studentRepository.existsById(studentID);
        if(!exists){
            throw new IllegalStateException("Student with ID: " + studentID + " does not present!");
        }
        studentRepository.deleteById(studentID);
    }

    @Override
    public Student updateStudent(Long studentID, Student student) {
        Student oldStudent = studentRepository.findStudentById(studentID);

        if (oldStudent.getName() != null && !oldStudent.getName().isEmpty() && !Objects.equals(oldStudent.getName(), student.getName())) {
            oldStudent.setName(student.getName());
        }
        if (oldStudent.getSurname() != null && !oldStudent.getSurname().isEmpty() && !Objects.equals(oldStudent.getSurname(), student.getSurname())) {
            oldStudent.setSurname(student.getSurname());
        }
        if (!Objects.equals(oldStudent.getCourse(), student.getCourse())) {
            oldStudent.setCourse(student.getCourse());
            switch (student.getCourse()){
                case "AF":
                    oldStudent.setCoursePrice(CourseInfo.AF.getPrice());
                    oldStudent.setDurationOfCourse(CourseInfo.AF.getDurationOfCourse());
                    break;
                case "CSF":
                    oldStudent.setCoursePrice(CourseInfo.CSF.getPrice());
                    oldStudent.setDurationOfCourse(CourseInfo.CSF.getDurationOfCourse());
                    break;
                case "EF":
                    oldStudent.setCoursePrice(CourseInfo.EF.getPrice());
                    oldStudent.setDurationOfCourse(CourseInfo.EF.getDurationOfCourse());
                    break;
                case "IRF":
                    oldStudent.setCoursePrice(CourseInfo.IRF.getPrice());
                    oldStudent.setDurationOfCourse(CourseInfo.IRF.getDurationOfCourse());
                    break;
                case "BMF":
                    oldStudent.setCoursePrice(CourseInfo.BMF.getPrice());
                    oldStudent.setDurationOfCourse(CourseInfo.BMF.getDurationOfCourse());
                    break;
            }
        }
        if (oldStudent.getEmail() != null && !oldStudent.getEmail().isEmpty() && !Objects.equals(oldStudent.getEmail(), student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentsByEmail(student.getEmail());
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Entered Email is taken");
            }
            oldStudent.setEmail(student.getEmail());
        }
        return studentRepository.save(oldStudent);
    }
}
