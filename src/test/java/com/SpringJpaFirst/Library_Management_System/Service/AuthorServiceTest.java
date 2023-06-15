package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AuthorServiceTest {

    @Autowired
    AuthorService authorService;
    @Mock
    AuthorRepository authorRepository;
    @BeforeEach
    void setUp(){
        Author author=authorRepository.findByAuthorName("Avishek");
        Mockito.when(authorRepository.findByAuthorName("Avishek")).thenReturn(author);

    }
    @Test
    void findAuthorByName() throws AuthorNotFoundException {
        String name="Avishek";
        Author author=authorService.findAuthorByName(name);
        assertEquals(name,author.getAuthorName());
    }
}