package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.Converter.AuthorConverter;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDtoByIdAndMail;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;
@Service
public class AuthorServiceImpl implements AuthorService{
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
    public AuthorResponseDto findById(int id) throws AuthorNotFoundException{
        Author author;
        try {
            author = authorRepository.findById(id).get();
        }catch (Exception e){
            throw new AuthorNotFoundException("Author is not present in our database..");
        }
        //make the author response dto
        AuthorResponseDto authorResponseDto=AuthorConverter.authorToAuthorResponseDto(author);
        return authorResponseDto;
    }
    public Author findAuthorByName(String name) throws AuthorNotFoundException {
        Author author;
        try {
            author = authorRepository.findByAuthorName(name);
        }catch (Exception e){
            throw new AuthorNotFoundException("Author is not present in our library");
        }
        return author;
    }
    public List<AuthorResponseDto> findAllAuthor(){
        List<Author> list=authorRepository.findAll();

        ArrayList<AuthorResponseDto> finalList=new ArrayList<>();
        for(Author key:list)
        {
            AuthorResponseDto authorResponseDto=AuthorConverter.authorToAuthorResponseDto(key);
            finalList.add(authorResponseDto);
        }
        return finalList;
    }

    public String deleteAuthor(AuthorRequestDtoByIdAndMail id) throws AuthorNotFoundException{
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

    public AuthorResponseDto updateAuthorDetails(AuthorRequestDtoByIdAndMail id) throws AuthorNotFoundException {
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
