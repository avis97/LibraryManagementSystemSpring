package com.SpringJpaFirst.Library_Management_System.Controller;

import com.SpringJpaFirst.Library_Management_System.DTO.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorRequestDtoById;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/author")
public class AuthorController{
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto)
    {
         return  authorService.addAuthor(authorRequestDto);
    }
    @GetMapping("/find_by_id")
    public AuthorResponseDto findById(@RequestBody AuthorRequestDtoById id)
    {
        return authorService.findById(id);
    }
    @GetMapping("/findAllAuthor")
    public List<AuthorResponseDto> findAllAuthor()
    {
        return authorService.findAllAuthor();
    }
    @PutMapping("/updateAuthor")
    public ResponseEntity updateAuthorDetails(@RequestBody AuthorRequestDtoById id) throws AuthorNotFoundException {
        AuthorResponseDto authorResponseDto;
        try
        {
            authorResponseDto=authorService.updateAuthorDetails(id);
        }
        catch(AuthorNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(authorResponseDto,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteAuthor")
    public ResponseEntity deleteAuthor(@RequestBody AuthorRequestDtoById id){
        String name;
        try{
            name=authorService.deleteAuthor(id);
        }
        catch(AuthorNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(name,HttpStatus.ACCEPTED);
    }
}
