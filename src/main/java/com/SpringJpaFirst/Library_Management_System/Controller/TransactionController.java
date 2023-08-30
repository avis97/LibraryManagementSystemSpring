package com.SpringJpaFirst.Library_Management_System.Controller;

import com.SpringJpaFirst.Library_Management_System.DTOs.IssueBookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.IssueBookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Transaction;
import com.SpringJpaFirst.Library_Management_System.Service.Impl.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController{
    @Autowired
    TransactionServiceImpl taransacTionService;


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

    @GetMapping("/getDetailsOf_transaction")
    public List<Transaction> transactionDetails(){

        return taransacTionService.transactionDetails();
    }
}