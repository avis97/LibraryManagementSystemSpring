package com.SpringJpaFirst.Library_Management_System.Service;
import com.SpringJpaFirst.Library_Management_System.DTO.IssueBookRequestDto;
import com.SpringJpaFirst.Library_Management_System.DTO.IssueBookResponseDto;
import com.SpringJpaFirst.Library_Management_System.Entity.Book;
import com.SpringJpaFirst.Library_Management_System.Entity.LibraryCard;
import com.SpringJpaFirst.Library_Management_System.Entity.Transaction;
import com.SpringJpaFirst.Library_Management_System.Enum.Status;
import com.SpringJpaFirst.Library_Management_System.Enum.TransactionStatus;
import com.SpringJpaFirst.Library_Management_System.Repository.BookRepository;
import com.SpringJpaFirst.Library_Management_System.Repository.CardRepository;
import com.SpringJpaFirst.Library_Management_System.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService{
    @Autowired
    CardRepository cardRepo;
    @Autowired
    TransactionRepository transRepo;
    @Autowired
    BookRepository bookRepo;

    public IssueBookResponseDto issueBooks(IssueBookRequestDto requestDto) throws Exception{

        Transaction transaction=new Transaction();
        transaction.setTransactionNUmber(String.valueOf(UUID.randomUUID()));
        transaction.setTransactionIssued(true);

        LibraryCard card;
        try{
            card=cardRepo.findById(requestDto.getCardId()).get();  //for check card is register or not
        }
        catch(Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Invalid Card Id");
            transRepo.save(transaction);
            throw new Exception("Invalid Card id.");
        }
        Book book;
        try{
            book=bookRepo.findById(requestDto.getBookId()).get();     // for check book is register or not..
        }
        catch(Exception e)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Invalid Book Id");
            transRepo.save(transaction);
            throw new Exception("Invalid Book Id");
        }

        transaction.setBook(book);
        transaction.setCard(card);
        //for check the two condition
        if(card.getStatus()!= Status.ACTIVATED)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("Your card is not activated.");
            transRepo.save(transaction);
            throw new Exception("Your card is not activated.");
        }
        if(book.isIssued()==true)
        {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMassage("The book is already Issued..you Can't take it again.");
            transRepo.save(transaction);
            throw new Exception("The book is already Issued..you Can't take it again.");
        }
        //Now can save the new record in our db
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransaction().add(transaction);
        card.getBookIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepo.save(card);  //save the final parent class card...because if you save the card also
                             //save the child(book,transaction automatic.

        //for return perpose..
        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
        issueBookResponseDto.setTransactionId(transaction.getTransactionNUmber());
        issueBookResponseDto.setTStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setBookPrice(book.getPrice());

        return issueBookResponseDto;
    }
}
