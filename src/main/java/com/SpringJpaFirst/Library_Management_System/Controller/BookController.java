package com.SpringJpaFirst.Library_Management_System.Controller;
import java.util.*;
import com.SpringJpaFirst.Library_Management_System.DTO.BookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.BookRequestDtoByName;
import com.SpringJpaFirst.Library_Management_System.DTO.BookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController{
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    private BookResponseDto addBook(@RequestBody  BookRequestDto bookRequestDto) throws AuthorNotFoundException {
        BookResponseDto bookResponseDto;
        try {
           bookResponseDto= bookService.addBook(bookRequestDto);
        }
        catch(Exception e)
        {
            throw new AuthorNotFoundException("Author Not Found");
        }
        return bookResponseDto;
    }
    @GetMapping("/find_by_name")
    private BookResponseDto getBookByName(@RequestBody BookRequestDtoByName name)
    {
        return bookService.getBookByName(name);
    }
    @GetMapping("/allBooks")
    private List<BookResponseDto> getAllBooks()
    {
        return bookService.getAllBooks();
    }
    @PutMapping("/updateBookdetails")
    private BookResponseDto updateBookDetailsByName(@RequestBody BookRequestDto bookRequestDto)
    {
        return bookService.updateBookDetailsByName(bookRequestDto);
    }
    @DeleteMapping("/delete_book_byName")
    private String deleteBookById(@RequestBody BookRequestDtoByName name)
    {
       return bookService.deleteBookByName(name);
    }
}
