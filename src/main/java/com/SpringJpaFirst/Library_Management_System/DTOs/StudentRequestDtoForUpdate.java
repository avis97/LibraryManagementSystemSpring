package com.SpringJpaFirst.Library_Management_System.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequestDtoForUpdate {
    private int studentId;
    private String newEmail;
}
