package com.SpringJpaFirst.Library_Management_System.Converter;

import com.SpringJpaFirst.Library_Management_System.DTOs.StudentRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.StudentResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Student;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StudentConverter{
    public static Student studentRequestDtoToStudent(StudentRequestDto studentRequestDto)
    {
        return Student.builder()
                .studentName(studentRequestDto.getName())
                .studentAge(studentRequestDto.getAge())
                .studentEmail(studentRequestDto.getEmail())
                .department(studentRequestDto.getDepartment())
                .build();
    }

    public static StudentResponseDto studentToStudentResponseDto(Student student)
    {
        return StudentResponseDto.builder()
                .StudentName(student.getStudentName())
                .StudentEmail(student.getStudentEmail())
                .Age(student.getStudentAge())
                .Department(student.getDepartment())
                .imageName(student.getImageName())
                .build();
    }
    public static Student StudentResponseDtoToStudent(StudentResponseDto dto){
        return  Student.builder()
                .studentName(dto.getStudentName())
                .studentEmail(dto.getStudentEmail())
                .studentAge(dto.getAge())
                .department(dto.getDepartment())
                .imageName(dto.getImageName())
                .build();
    }
    public static StudentRequestDto StudentToStudentRequestDto(Student student){
        return StudentRequestDto.builder()
                .imageFile(student.getImageName())
                .name(student.getStudentName())
                .age(student.getStudentAge())
                .department(student.getDepartment())
                .email(student.getStudentEmail())
                .build();
    }
}
