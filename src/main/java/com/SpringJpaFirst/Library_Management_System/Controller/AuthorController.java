package com.SpringJpaFirst.Library_Management_System.Controller;


import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorRequestDtoByIdAndMail;
import com.SpringJpaFirst.Library_Management_System.DTOs.AuthorResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Exception.AuthorNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Service.Impl.AuthorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/author")
public class AuthorController{
    @Autowired
    AuthorServiceImpl authorServiceImpl;
    @Value("${welcome.message}")
    private String welComeMessage;
    @GetMapping("/home")
    public String getWelComePage(){
        return welComeMessage;
    }

    //logger for debug
    private final Logger LOGGER=
                LoggerFactory.getLogger(AuthorController.class);

    @PostMapping("/add")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto)
    {
         LOGGER.info("Author Save in AuthorRepository");
         return  authorServiceImpl.addAuthor(authorRequestDto);
    }
    @GetMapping("/find_by_id/{id}")
    public ResponseEntity findById(@PathVariable("id") int id) throws AuthorNotFoundException{
          AuthorResponseDto authorResponseDto;
          try{
              authorResponseDto=authorServiceImpl.findById(id);
          }catch(AuthorNotFoundException e){
              return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
          }
          LOGGER.info("This is the Author.");
          return new  ResponseEntity(authorResponseDto,HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllAuthor")
    public List<AuthorResponseDto> findAllAuthor() {
        return authorServiceImpl.findAllAuthor();
    }

    @PutMapping("/updateAuthor")
    public ResponseEntity updateAuthorDetails(@RequestBody AuthorRequestDtoByIdAndMail id){
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
    @GetMapping("/findAuthorByName/{name}")
    public ResponseEntity findAuthorByName(@PathVariable("name") String name){
        Author author;
        try{
            author=authorServiceImpl.findAuthorByName(name);
        }catch (AuthorNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
       return new ResponseEntity(author,HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAuthorByAge/{age}")
    public ResponseEntity authorByAge(@PathVariable("age") int age){
        List<Author> authors;
        try{
            authors=authorServiceImpl.authorByAge(age);
        }catch (AuthorNotFoundException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(authors,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/deleteAuthor")
    public ResponseEntity deleteAuthor(@RequestBody AuthorRequestDtoByIdAndMail id){
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
