package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.DTOs.BookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.BookRequestDtoByName;
import com.SpringJpaFirst.Library_Management_System.DTOs.BookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;

import java.util.List;

public interface BookService{

    BookResponseDto addBook(BookRequestDto bookRequestDto) throws AuthorNotFoundException;
    BookResponseDto getBookByName(BookRequestDtoByName name);
    String deleteBookByName(BookRequestDtoByName name);
    List<BookResponseDto> getAllBooks();
    BookResponseDto updateBookDetailsByName(BookRequestDto bookRequestDto);
}
