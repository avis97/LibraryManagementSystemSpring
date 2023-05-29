package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDtoById;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;

import java.util.List;

public interface AuthorService{
    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);
    AuthorResponseDto findById(AuthorRequestDtoById id);
    List<AuthorResponseDto> findAllAuthor();
    String deleteAuthor(AuthorRequestDtoById id)throws AuthorNotFoundException;
    AuthorResponseDto updateAuthorDetails(AuthorRequestDtoById id) throws AuthorNotFoundException;
}
