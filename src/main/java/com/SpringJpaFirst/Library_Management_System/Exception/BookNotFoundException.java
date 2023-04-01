package com.SpringJpaFirst.Library_Management_System.Exception;

import lombok.experimental.UtilityClass;

public class BookNotFoundException extends Exception{

    public BookNotFoundException(String massage)
    {
        super(massage);
    }
}
