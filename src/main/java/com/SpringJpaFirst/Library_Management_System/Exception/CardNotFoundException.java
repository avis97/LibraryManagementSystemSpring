package com.SpringJpaFirst.Library_Management_System.Exception;

import lombok.experimental.UtilityClass;


public class CardNotFoundException extends Exception{

    public CardNotFoundException(String Massage)
    {
        super(Massage);
    }
}
