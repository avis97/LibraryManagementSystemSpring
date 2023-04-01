package com.SpringJpaFirst.Library_Management_System.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDtoById {
    private int studentId;
}
