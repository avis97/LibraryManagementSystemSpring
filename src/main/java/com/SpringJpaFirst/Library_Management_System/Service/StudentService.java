package com.SpringJpaFirst.Library_Management_System.Service;
import com.SpringJpaFirst.Library_Management_System.DTOs.*;
import java.util.List;
public interface StudentService{
    StudentResponseDto addStudent(StudentRequestDto studentRequestDto);
    StudentResponseDto findByEmail(StudentRequestDtoByEmail forEmail);
    StudentResponseDto findById(StudentRequestDtoById id);
    String deleteStudentById(StudentRequestDtoById id);
    StudentResponseDto updateStudentById(StudentRequestDtoForUpdate email);
    List<StudentResponseDto> allStudentDetails();
    StudentResponseDto highestAgeStudent();
}
