package com.SpringJpaFirst.Library_Management_System.Repository;

import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

    //you can make own calling method by find by
    Student findByEmail(String email);    //this approach you can make own findBy method.
    List<Student> findByAge(int age);
}
