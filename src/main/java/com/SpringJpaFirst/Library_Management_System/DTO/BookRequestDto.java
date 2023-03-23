package com.SpringJpaFirst.Library_Management_System.DTO;


import com.SpringJpaFirst.Library_Management_System.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookRequestDto{
    private String title;
    private int price;
    private Genre genre;
    private int authorId;
}
