package com.SpringJpaFirst.Library_Management_System.Controller;


import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController{

    @Autowired
    AuthorService aService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author)
    {
        aService.addAuthor(author);
        return "Author added successfully.";
    }
}
