package com.SpringJpaFirst.Library_Management_System.Repository;

import java.util.*;
import com.SpringJpaFirst.Library_Management_System.DTOs.StudentRequestDtoById;
import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    Student findByStudentEmail(String email);

    //this is a native query for special sql
    @Query(
            value = "SELECT * FROM student WHERE student_age=?1",
            nativeQuery = true
    )
    List<Student> findByStudentByAge(int age);
}
