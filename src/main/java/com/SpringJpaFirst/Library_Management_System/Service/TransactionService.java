package com.SpringJpaFirst.Library_Management_System.Service;

import com.SpringJpaFirst.Library_Management_System.DTOs.IssueBookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.IssueBookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Transaction;

import java.util.List;

public interface TransactionService{

    IssueBookResponseDto issueNewBookTransaction(IssueBookRequestDto requestDto) throws Exception;
    List<Transaction> transactionDetails();
}
