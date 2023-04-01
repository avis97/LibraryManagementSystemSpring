package com.SpringJpaFirst.Library_Management_System.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentRequestDtoByEmail {
    private String studentEmail;
}
