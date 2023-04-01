package com.SpringJpaFirst.Library_Management_System.Exception;
import com.SpringJpaFirst.Library_Management_System.Entity.Author;

public class AuthorNotFoundException extends Exception{
    public AuthorNotFoundException(String Massage)
    {
        super(Massage);
    }
}
