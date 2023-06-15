package com.SpringJpaFirst.Library_Management_System.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FontController{
    @GetMapping("/index")
    public String home(){
        return "index";
    }
}
