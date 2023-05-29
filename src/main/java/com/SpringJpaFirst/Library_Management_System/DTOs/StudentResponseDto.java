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
public class StudentResponseDto{
    private String StudentName;
    private String StudentEmail;
    private Department Department;
    private int Age;
}
