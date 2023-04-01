package com.SpringJpaFirst.Library_Management_System.Converter;

import com.SpringJpaFirst.Library_Management_System.DTO.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import lombok.experimental.UtilityClass;
@UtilityClass
public class AuthorConverter{
    public static Author authorRequestDtoToAuthor(AuthorRequestDto authorRequestDto)
    {
        return Author.builder()
                .authorName(authorRequestDto.getAuthorName())
                .authorEmail(authorRequestDto.getAuthorEmail())
                .authorAge(authorRequestDto.getAuthorAge())
                .authorPhoneNo(authorRequestDto.getPhoneNumber())
                .build();
    }
    public static AuthorResponseDto authorToAuthorResponseDto(Author author)
    {
        return  AuthorResponseDto.builder()
                .authorPhnNo(author.getAuthorPhoneNo())
                .authorId(author.getAuthorId())
                .authorEmail(author.getAuthorEmail())
                .authorName(author.getAuthorName())
                .build();
    }
}
