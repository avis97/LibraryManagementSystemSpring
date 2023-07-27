package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthorServiceTest {
    @Autowired
    AuthorService authorService;
    @Mock
    AuthorRepository authorRepository;
    Author author;
    @BeforeEach
    void setUp(){
         author=authorRepository.findByAuthorName("Avishek");
         Mockito.when(authorRepository.findByAuthorName("Avishek")).thenReturn(author);
         Mockito.when(authorRepository.findById(1)).thenReturn(Optional.ofNullable(author));
    }
    @Test
    void findAuthorByName() throws AuthorNotFoundException {
        String name="Avishek";
        Author author=authorService.findAuthorByName(name);
        assertEquals(name,author.getAuthorName());
    }
    @Test
    void findAuthorById() throws AuthorNotFoundException {
        AuthorResponseDto responseDto =authorService.findById(1);
        assertEquals(1,responseDto.getAuthorId());
        System.out.println(responseDto.getAuthorName());
    }
}