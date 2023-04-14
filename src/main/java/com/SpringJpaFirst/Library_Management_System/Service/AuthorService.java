package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.Converter.AuthorConverter;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorRequestDtoById;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;
@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto){
        //convert RequestDto to Author by using converter.
        Author author=AuthorConverter.authorRequestDtoToAuthor(authorRequestDto);

        //save the author to author repository.
        authorRepository.save(author);
        //change author to author ResponseDto
        AuthorResponseDto authorResponseDto=AuthorConverter.authorToAuthorResponseDto(author);
        return authorResponseDto;
    }

    public AuthorResponseDto findById(AuthorRequestDtoById id){

        Author author=authorRepository.findById(id.getAuthorId()).get();

        AuthorResponseDto authorResponseDto=AuthorConverter.authorToAuthorResponseDto(author);
        return authorResponseDto;
    }

    public List<AuthorResponseDto> findAllAuthor(){
        List<Author> list=authorRepository.findAll();

        ArrayList<AuthorResponseDto> finalList=new ArrayList<>();
        for(Author key:list)
        {
            AuthorResponseDto author=AuthorConverter.authorToAuthorResponseDto(key);
            finalList.add(author);
        }
        return finalList;
    }

    public String deleteAuthor(AuthorRequestDtoById id) throws AuthorNotFoundException {
        Author author;
        try {
            author = authorRepository.findById(id.getAuthorId()).get();
        }
        catch(Exception e)
        {
            throw new AuthorNotFoundException("Opps!!!Author is Not found");
        }
        authorRepository.delete(author);

        String authorName=author.getAuthorName();

        return authorName+" This Author Deleted Successfully";
    }
    public AuthorResponseDto updateAuthorDetails(AuthorRequestDtoById id) throws AuthorNotFoundException {
        Author author;
        try {
            author = authorRepository.findById(id.getAuthorId()).get();
        }
        catch(Exception e)
        {
            throw new AuthorNotFoundException("Author is Not Present");
        }
        // set the new email id in our repo.
        author.setAuthorEmail(id.getNewEmail());
        //save new details in repository.
        authorRepository.save(author);
        //make change
        AuthorResponseDto authorResponseDto=AuthorConverter.authorToAuthorResponseDto(author);

        return authorResponseDto;
    }
}
