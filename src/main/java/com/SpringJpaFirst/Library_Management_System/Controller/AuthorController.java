package com.SpringJpaFirst.Library_Management_System.Controller;

import com.SpringJpaFirst.Library_Management_System.DTO.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorRequestDtoById;
import com.SpringJpaFirst.Library_Management_System.DTO.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
