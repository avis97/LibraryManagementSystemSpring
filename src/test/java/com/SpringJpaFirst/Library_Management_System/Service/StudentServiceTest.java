package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.DTOs.StudentResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentServiceTest {
    @Autowired
    StudentService studentService;

    @BeforeEach
    void setUp(){

    }
    @Test
    void studentFindByEmail(){
        StudentResponseDto student=studentService.findByEmail("robi@gmail.com");
        assertEquals("rabi",student.getStudentName());
    }
}