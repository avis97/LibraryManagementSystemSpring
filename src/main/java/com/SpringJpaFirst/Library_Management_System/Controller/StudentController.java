package com.SpringJpaFirst.Library_Management_System.Controller;

import com.SpringJpaFirst.Library_Management_System.DTO.*;
import com.SpringJpaFirst.Library_Management_System.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController{
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    private StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentService.addStudent(studentRequestDto);
    }
    @GetMapping("/find_by_email")
    private StudentResponseDto getStudentByEmail(@RequestBody StudentRequestDtoByEmail studentRequestDtoByEmail)
    {
        return studentService.findByEmail(studentRequestDtoByEmail);
    }
    @GetMapping("/find_by_id")
    private StudentResponseDto getStudentByNo(@RequestBody StudentRequestDtoById id)
    {
        return studentService.findById(id);
    }
    @PutMapping("update_by_id")
    private StudentResponseDto updateStudentById(@RequestBody BookRequestDtoForUpdate email)
    {
        return studentService.updateStudentById(email);
    }
    @DeleteMapping("/delete_by_id")
    private  String  deleteStudentById(@RequestBody StudentRequestDtoById id)
    {
       return studentService.deleteStudentById(id);
    }
}
