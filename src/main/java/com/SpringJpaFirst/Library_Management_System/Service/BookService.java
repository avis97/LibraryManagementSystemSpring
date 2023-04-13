package com.SpringJpaFirst.Library_Management_System.Service;

import java.util.*;
import com.SpringJpaFirst.Library_Management_System.Converter.BookConverter;
import com.SpringJpaFirst.Library_Management_System.DTO.BookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.BookRequestDtoByName;
import com.SpringJpaFirst.Library_Management_System.DTO.BookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.Repository.AuthorRepository;
import com.SpringJpaFirst.Library_Management_System.Repository.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws AuthorNotFoundException{
        Author author;
        try{
            author=authorRepository.findById(bookRequestDto.getAuthorId()).get(); //check author present or not
        }
        catch(Exception e)
        {
            throw new AuthorNotFoundException("Ops!!Author Not Found In Our Portal");
        }
        //convert bookRequestDto to Book
        Book book= BookConverter.bookRequestDtoToBook(bookRequestDto);

        //add the author im the book data;
        book.setAuthor(author);

        //add the book in the author bookList
        List<Book> bookList=author.getBook();
        bookList.add(book);

        //save the author because book is a child of author
        authorRepository.save(author);

        //prepare book to bookResponseDto
        BookResponseDto bookResponseDto=BookConverter.bookToBookResponseDto(book);
        return bookResponseDto;
    }
    public BookResponseDto getBookByName(BookRequestDtoByName name){

        Book book=bookRepository.findByBookTitle(name.getBookName());

        //Convert book to bookResponseDto by BookConverter.
        BookResponseDto bookResponseDto=BookConverter.bookToBookResponseDto(book);
        return bookResponseDto;
    }
    public String deleteBookByName(BookRequestDtoByName name){
        Book book=bookRepository.findByBookTitle(name.getBookName());
        bookRepository.delete(book);
        String Name=book.getBookTitle();
        return Name+" This Book Deleted Done!!";
    }
}
