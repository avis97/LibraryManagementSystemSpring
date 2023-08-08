package com.SpringJpaFirst.Library_Management_System.Controller;

import java.util.*;
import com.SpringJpaFirst.Library_Management_System.DTOs.*;
import com.SpringJpaFirst.Library_Management_System.Exception.StudentNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Service.AuthorImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController{
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping("/add")
    public  StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto)
    {
        return studentServiceImpl.addStudent(studentRequestDto);
    }

    @GetMapping("/find_by_email/{mail}")
    public StudentResponseDto getStudentByEmail(@PathVariable("mail") String mail)
    {
        return studentServiceImpl.findByEmail(mail);
    }

    @GetMapping("/find_by_id")
    public ResponseEntity<StudentResponseDto> getStudentByNo(@RequestBody StudentRequestDtoById id) throws StudentNotFoundException{
        StudentResponseDto studentResponseDto=new StudentResponseDto();
        try{
            studentResponseDto=studentServiceImpl.findById(id);
        }
        catch(StudentNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(studentResponseDto,HttpStatus.ACCEPTED);
    }

    @PutMapping("update_by_id")
    public StudentResponseDto updateStudentById(@RequestBody StudentRequestDtoForUpdate email)
    {
        return studentServiceImpl.updateStudentById(email);
    }

    @GetMapping("/allStudent")
    public List<StudentResponseDto> allStudentDetails()
    {
        return studentServiceImpl.allStudentDetails();
    }

    @GetMapping("/highestAgeStudent")
    public StudentResponseDto highestAgeStudent()
    {
        return studentServiceImpl.highestAgeStudent();
    }
    @GetMapping("/getStudentByAge/{age}")
    public List<StudentResponseDto> findStudentBySameAge(@PathVariable("age") int age){
        return studentServiceImpl.findStudentBySameAge(age);
    }
    @DeleteMapping("/delete_by_id")
    private  String  deleteStudentById(@RequestBody StudentRequestDtoById id)
    {
       return studentServiceImpl.deleteStudentById(id);
    }
}
