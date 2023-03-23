package com.SpringJpaFirst.Library_Management_System.Controller;


import com.SpringJpaFirst.Library_Management_System.DTO.StudentRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.StudentResponseDTO;
import com.SpringJpaFirst.Library_Management_System.DTO.StudentUpdateClass;
import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import com.SpringJpaFirst.Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Status;

@RestController
@RequestMapping("/student")
public class StudentController{
    @Autowired
    StudentService studentservice;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto student)
    {
        studentservice.addStudent(student);
        return "Student added successfully.";
    }
    @GetMapping("/find_by_email")
    public String findNameByEmail(@RequestParam("email") String email)
    {
        return studentservice.findNameByEmail(email);
    }
    @PutMapping("/updateStudentEmail")
    public StudentResponseDTO updateStudentEmail(@RequestBody StudentUpdateClass sUpdate)
    {
        return studentservice.updateStudentEmail(sUpdate);
    }
}
