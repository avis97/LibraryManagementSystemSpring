package com.SpringJpaFirst.Library_Management_System.Repository;

import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;
    @BeforeEach
    void setUp(){
    }
    @Test
    void findByStudentNameFirstLatter(){
        List<Student> studentList=studentRepository.findByStudentByAge(24);
        for(int i=0;i<studentList.size();i++){
            System.out.print("Student Name is "+studentList.get(i).getStudentName()
                    +" id "+studentList.get(i).getStudentId());
        }
    }
}