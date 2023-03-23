package com.SpringJpaFirst.Library_Management_System.Controller;


import com.SpringJpaFirst.Library_Management_System.DTO.BookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.BookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import com.SpringJpaFirst.Library_Management_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController{
    @Autowired
    BookService bService;
    @PostMapping("/add")
    public BookResponseDto addBooks(@RequestBody BookRequestDto book){
        return bService.addBooks(book);
    }
}
