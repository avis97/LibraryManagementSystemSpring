package com.SpringJpaFirst.Library_Management_System.Service;

import java.util.*;
import com.SpringJpaFirst.Library_Management_System.Converter.BookConverter;
import com.SpringJpaFirst.Library_Management_System.DTOs.BookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.BookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.AuthorRepository;
import com.SpringJpaFirst.Library_Management_System.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{
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

    public BookResponseDto getBookByName(String name){

        Book book=bookRepository.findByBookTitle(name);

        //Convert book to bookResponseDto by BookConverter.
        BookResponseDto bookResponseDto=BookConverter.bookToBookResponseDto(book);
        return bookResponseDto;
    }

    public String deleteBookByName(String name){
        Book book=bookRepository.findByBookTitle(name);
        bookRepository.delete(book);
        String Name=book.getBookTitle();
        return Name+" This Book Deleted Done!!";
    }

    public List<BookResponseDto> getAllBooks(){
        List<Book> books=bookRepository.findAll();

        List<BookResponseDto> bookList=new ArrayList<>();
        for(Book book:books)
        {
            BookResponseDto bookResponseDto=BookConverter.bookToBookResponseDto(book);
            bookList.add(bookResponseDto);
        }
        return bookList;
    }

    public BookResponseDto updateBookDetailsByName(BookRequestDto bookRequestDto){

          Book book=bookRepository.findByBookTitle(bookRequestDto.getBookName());

          book.setPrice(bookRequestDto.getPrice());

          Author author=book.getAuthor();

          authorRepository.save(author);

          //make to a bookResponseDto
          BookResponseDto bookResponseDto=BookConverter.bookToBookResponseDto(book);

          return bookResponseDto;
    }
}
