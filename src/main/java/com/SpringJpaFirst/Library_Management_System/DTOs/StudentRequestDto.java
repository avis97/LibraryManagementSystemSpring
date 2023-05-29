package com.SpringJpaFirst.Library_Management_System.DTOs;

import com.SpringJpaFirst.Library_Management_System.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDto{
    private String name;
    private int age;
    private Department department;
    private String email;
}
