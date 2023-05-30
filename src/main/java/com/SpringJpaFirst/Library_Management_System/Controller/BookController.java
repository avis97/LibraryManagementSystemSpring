package com.SpringJpaFirst.Library_Management_System.Controller;

import java.util.*;
import com.SpringJpaFirst.Library_Management_System.DTOs.BookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.BookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController{
    @Autowired
    BookServiceImpl bookServiceImpl;
    @PostMapping("/add")
    private BookResponseDto addBook(@RequestBody  BookRequestDto bookRequestDto) throws AuthorNotFoundException {
        BookResponseDto bookResponseDto;
        try {
           bookResponseDto= bookServiceImpl.addBook(bookRequestDto);
        }
        catch(Exception e)
        {
            throw new AuthorNotFoundException("Author Not Found");
        }
        return bookResponseDto;
    }
    @GetMapping("/find_by_name/{name}")
    private BookResponseDto getBookByName(@PathVariable("name") String name)
    {
        return bookServiceImpl.getBookByName(name);
    }
    @GetMapping("/allBooks")
    private List<BookResponseDto> getAllBooks()
    {
        return bookServiceImpl.getAllBooks();
    }
    @PutMapping("/updateBookdetails")
    private BookResponseDto updateBookDetailsByName(@RequestBody BookRequestDto bookRequestDto)
    {
        return bookServiceImpl.updateBookDetailsByName(bookRequestDto);
    }
    @DeleteMapping("/delete_book_byName/{name}")
    private String deleteBookById(@PathVariable("name") String name)
    {
       return bookServiceImpl.deleteBookByName(name);
    }
}
