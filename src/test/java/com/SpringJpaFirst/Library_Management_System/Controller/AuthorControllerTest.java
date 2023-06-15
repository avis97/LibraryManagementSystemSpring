package com.SpringJpaFirst.Library_Management_System.Controller;

import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.AuthorRepository;
import com.SpringJpaFirst.Library_Management_System.Service.AuthorService;
import com.SpringJpaFirst.Library_Management_System.Service.AuthorServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
class AuthorControllerTest{
    @Autowired
    MockMvc mockMvc;
    @MockBean
    AuthorServiceImpl authorService;
    Author author;
    @BeforeEach
    void setUp() throws AuthorNotFoundException {
 //   author=authorService.findAuthorByName("Avishek");
    }
    @Test
    void findAuthorByName() throws Exception{
        Mockito.when(authorService.findAuthorByName("Avishek")).thenReturn(author);

        mockMvc.perform(MockMvcRequestBuilders.get("/author/findAuthorByName/Avishek")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher)jsonPath("$.authorName")
                        .value(author.getAuthorName()));
    }
}