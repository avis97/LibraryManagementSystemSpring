package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDtoByIdAndMail;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;

import java.util.List;

public interface AuthorService{
    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
    AuthorResponseDto findById(int id) throws AuthorNotFoundException;
    List<AuthorResponseDto> findAllAuthor();
    String deleteAuthor(AuthorRequestDtoByIdAndMail id)throws AuthorNotFoundException;
    AuthorResponseDto updateAuthorDetails(AuthorRequestDtoByIdAndMail id) throws AuthorNotFoundException;
    Author findAuthorByName(String name) throws AuthorNotFoundException;

    List<Author> authorByAge(int age) throws AuthorNotFoundException;
}
