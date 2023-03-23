package com.SpringJpaFirst.Library_Management_System.Controller;

import com.SpringJpaFirst.Library_Management_System.DTO.IssueBookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.IssueBookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController{
    @Autowired
    TransactionService tranService;
    @PostMapping("/add")
    public ResponseEntity issueBooks(@RequestBody IssueBookRequestDto requestDto) throws Exception
    {
        IssueBookResponseDto issueBookResponseDto;
        try{
             issueBookResponseDto=tranService.issueBooks(requestDto);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(issueBookResponseDto,HttpStatus.ACCEPTED);
    }
}
