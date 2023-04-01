package com.SpringJpaFirst.Library_Management_System.Controller;

import com.SpringJpaFirst.Library_Management_System.DTO.IssueBookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.IssueBookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Exception.BookNotFoundException;
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
    TransactionService taransacTionService;
    @PostMapping("/issue")
    public ResponseEntity issueNewBookTransaction(@RequestBody IssueBookRequestDto requestDto) throws Exception {
        IssueBookResponseDto responseDto;
        try {
            responseDto = taransacTionService.issueNewBookTransaction(requestDto);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(responseDto,HttpStatus.ACCEPTED);
    }

}