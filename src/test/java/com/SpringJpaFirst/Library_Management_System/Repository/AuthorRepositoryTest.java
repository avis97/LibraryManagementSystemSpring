package com.SpringJpaFirst.Library_Management_System.Repository;
import java.util.*;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AuthorRepositoryTest{
    @Autowired
    AuthorRepository authorRepository;
    @BeforeEach
    void setUp(){

    }
    @Test
    public void findAllAuthor(){
        List<Author> list=authorRepository.findAll();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getAuthorName()+" ");
        }
    }
    @Test
    public void findAuthorById(){
        Author author=authorRepository.findById(1).get();
        System.out.println(author.getAuthorName());
        assertEquals(1,author.getAuthorId());
    }
    @Test
    public void findAuthorByName(){
        Author author=authorRepository.findByAuthorName("Avishek");
        System.out.println(author.getAuthorName());
        assertEquals("Avishek",author.getAuthorName());
    }
}