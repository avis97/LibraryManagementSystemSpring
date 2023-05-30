package com.SpringJpaFirst.Library_Management_System.Controller;

import java.util.*;
import com.SpringJpaFirst.Library_Management_System.DTOs.*;
import com.SpringJpaFirst.Library_Management_System.Service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController{
    @Autowired
    StudentServiceImpl studentServiceImpl;
    @PostMapping("/add")
    private StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentServiceImpl.addStudent(studentRequestDto);
    }
    @GetMapping("/find_by_email/{mail}")
    private StudentResponseDto getStudentByEmail(@PathVariable("mail") String mail)
    {
        return studentServiceImpl.findByEmail(mail);
    }
    @GetMapping("/find_by_id}")
    private StudentResponseDto getStudentByNo(@RequestBody StudentRequestDtoById id)
    {
        return studentServiceImpl.findById(id);
    }
    @PutMapping("update_by_id")
    private StudentResponseDto updateStudentById(@RequestBody StudentRequestDtoForUpdate email)
    {
        return studentServiceImpl.updateStudentById(email);
    }
    @GetMapping("/allStudent")
    private List<StudentResponseDto> allStudentDetails()
    {
        return studentServiceImpl.allStudentDetails();
    }
    @GetMapping("/highestAgeStudent")
    public StudentResponseDto highestAgeStudent()
    {
        return studentServiceImpl.highestAgeStudent();
    }
    @DeleteMapping("/delete_by_id")
    private  String  deleteStudentById(@RequestBody StudentRequestDtoById id)
    {
       return studentServiceImpl.deleteStudentById(id);
    }
}
