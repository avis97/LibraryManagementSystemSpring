package com.SpringJpaFirst.Library_Management_System.Converter;

import com.SpringJpaFirst.Library_Management_System.DTOs.BookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.BookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookConverter {
    public static Book bookRequestDtoToBook(BookRequestDto bookRequestDto)
    {
        return Book.builder()
                .bookTitle(bookRequestDto.getBookName())
                .price(bookRequestDto.getPrice())
                .genre(bookRequestDto.getGenre())
                .bookIsIssued(false)
                .build();
    }
    public static BookResponseDto bookToBookResponseDto(Book book)
    {
       return  BookResponseDto.builder()
               .BookName(book.getBookTitle())
               .price(book.getPrice())
               .genre(book.getGenre())
               .authorName(book.getAuthor().getAuthorName())
               .build();
    }
}
