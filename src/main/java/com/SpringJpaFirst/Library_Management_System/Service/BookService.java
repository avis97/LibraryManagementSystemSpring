package com.SpringJpaFirst.Library_Management_System.Service;


import com.SpringJpaFirst.Library_Management_System.DTO.BookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.BookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import com.SpringJpaFirst.Library_Management_System.Repository.AuthorRepository;
import com.SpringJpaFirst.Library_Management_System.Repository.BookRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService{
    @Autowired
    AuthorRepository authorRepo;
    public BookResponseDto addBooks(BookRequestDto bookDto){
        Author author=authorRepo.findById(bookDto.getAuthorId()).get();

        Book book=new Book();
        book.setTitle(bookDto.getTitle());
        book.setPrice(bookDto.getPrice());
        book.setGenre(bookDto.getGenre());
        book.setIssued(false);
        book.setAuthor(author);

        author.getBook().add(book);
        authorRepo.save(author);

        BookResponseDto bookResDto=new BookResponseDto();
        bookResDto.setTitle(book.getTitle());
        bookResDto.setPrice(book.getPrice());

        return bookResDto;
    }
}
