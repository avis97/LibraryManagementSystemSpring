package com.SpringJpaFirst.Library_Management_System.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorRequestDto{
    private String authorName;
    private String authorEmail;
    private String phoneNumber;
    private int authorAge;

}