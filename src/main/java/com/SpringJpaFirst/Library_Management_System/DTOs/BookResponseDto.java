package com.SpringJpaFirst.Library_Management_System.DTOs;

import com.SpringJpaFirst.Library_Management_System.Enum.ClassFor;
import com.SpringJpaFirst.Library_Management_System.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDto{
    private String BookName;
    private int price;
    private Genre genre;
    private ClassFor classFor;
    private String authorName;
}
