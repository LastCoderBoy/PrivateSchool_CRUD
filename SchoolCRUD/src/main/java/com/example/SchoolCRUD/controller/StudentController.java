package com.example.SchoolCRUD.controller;

import com.example.SchoolCRUD.domain.Student;
import com.example.SchoolCRUD.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/privateSchool")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/students")
    public String getStudents(Model model){
        try {
            List<Student> studentList = studentService.getStudents();
            model.addAttribute("allStudents", studentList);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }
        return "allStudents";

    }
    @GetMapping("students/new")
    public String addNewStudent(Model model){
        model.addAttribute("student", new Student());
        return "newStudent";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.addNewStudent(student);
        return "redirect:/api/v1/privateSchool/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentsById(id));
        return "editStudent";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {
        studentService.updateStudent(id, student);
        return "redirect:/api/v1/privateSchool/students";
    }


    @RequestMapping(path = "/del/{studentID}")
    public String deleteStudent(@PathVariable("studentID") Long studentID){
        studentService.deleteStudent(studentID);
        return "redirect:/api/v1/privateSchool/students";
    }


}
