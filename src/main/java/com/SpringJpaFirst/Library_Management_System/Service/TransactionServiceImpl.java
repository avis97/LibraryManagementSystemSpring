package com.SpringJpaFirst.Library_Management_System.Service;
import com.SpringJpaFirst.Library_Management_System.DTOs.IssueBookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTOs.IssueBookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import com.SpringJpaFirst.Library_Management_System.Entity.LibraryCard;
import com.SpringJpaFirst.Library_Management_System.Entity.Transaction;
import com.SpringJpaFirst.Library_Management_System.Enum.Status;
import com.SpringJpaFirst.Library_Management_System.Enum.TransactionStatus;
import com.SpringJpaFirst.Library_Management_System.Exception.BookNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Exception.CardNotFoundException;
import com.SpringJpaFirst.Library_Management_System.Repository.Repository.BookRepository;
import com.SpringJpaFirst.Library_Management_System.Repository.Repository.CardRepository;
import com.SpringJpaFirst.Library_Management_System.Repository.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;
    public IssueBookResponseDto issueNewBookTransaction(IssueBookRequestDto requestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setTransactionIssued(true);

        Book book;
        try {
            book = bookRepository.findById(requestDto.getBookId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMassage("Book id is invalid!!!");
            throw new BookNotFoundException("Book id is invalid");
        }

        LibraryCard card;
        try {
            card = cardRepository.findById(requestDto.getCardId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMassage("Card id Is invalid!!");
            throw new CardNotFoundException("Card id Is invalid!!");
        }

        transaction.setBook(book);
        transaction.setCard(card);

        if (card.getStatus() != Status.ACTIVATED) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMassage("Opps..!! Your card is not Active");
            throw new Exception("Opps..!! Your card is not Active");
        }
        if (book.isBookIsIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            transaction.setMassage("Opps..!! Book is All Ready Issue");
            throw new Exception("Opps..!! Book is All Ready Issue");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMassage("Transaction is success..");
        book.setBookIsIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);
        card.getTransactionList().add(transaction);
        card.getBookIssued().add(book);

        cardRepository.save(card); //card is parent of book and transaction so book and transaction will save it.


        //make the IssueBook response dto

        IssueBookResponseDto bookResponseDto = new IssueBookResponseDto();
        bookResponseDto.setBookName(book.getBookTitle());
        bookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        bookResponseDto.setCardId(card.getCardId());
        bookResponseDto.setTansactionDate(transaction.getTransactionDate());
        bookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        return bookResponseDto;
        }

    public List<Transaction> transactionDetails(){
        List<Transaction> list=transactionRepository.findAll();
        return list;
    }
}


