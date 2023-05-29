package com.SpringJpaFirst.Library_Management_System.Controller;

import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDtoById;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/author")
public class AuthorController{
    @Autowired
    AuthorServiceImpl authorServiceImpl;
    @PostMapping("/add")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto)
    {
         return  authorServiceImpl.addAuthor(authorRequestDto);
    }
    @GetMapping("/find_by_id")
    public AuthorResponseDto findById(@RequestBody AuthorRequestDtoById id)
    {
        return authorServiceImpl.findById(id);
    }
    @GetMapping("/findAllAuthor")
    public List<AuthorResponseDto> findAllAuthor()
    {
        return authorServiceImpl.findAllAuthor();
    }
    @PutMapping("/updateAuthor")
    public ResponseEntity updateAuthorDetails(@RequestBody AuthorRequestDtoById id) throws AuthorNotFoundException{
        AuthorResponseDto authorResponseDto;
        try
        {
            authorResponseDto= authorServiceImpl.updateAuthorDetails(id);
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
            name= authorServiceImpl.deleteAuthor(id);
        }
        catch(AuthorNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(name,HttpStatus.ACCEPTED);
    }
}
