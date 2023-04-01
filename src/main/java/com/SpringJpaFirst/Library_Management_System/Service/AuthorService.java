package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.Converter.AuthorConverter;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Repository.AuthorRepository;
import com.SpringJpaFirst.Library_Management_System.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto){
        //convert RequestDto to Author by using converter.
        Author author=AuthorConverter.authorRequestDtoToAuthor(authorRequestDto);

        //save the author to author repository.
        authorRepository.save(author);
        //change author to author Responsedto
        AuthorResponseDto authorResponseDto=AuthorConverter.authorToAuthorResponseDto(author);
        return authorResponseDto;
    }
}
