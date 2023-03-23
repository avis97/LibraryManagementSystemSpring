package com.SpringJpaFirst.Library_Management_System.Service;


import com.SpringJpaFirst.Library_Management_System.Entity.Author;
import com.SpringJpaFirst.Library_Management_System.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService{

    @Autowired
    AuthorRepository aRepo;
    public void addAuthor(Author author){
         aRepo.save(author);
    }
}
