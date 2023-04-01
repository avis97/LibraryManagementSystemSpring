package com.SpringJpaFirst.Library_Management_System.Repository;

import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
    Student findByStudentEmail(String email);
}
