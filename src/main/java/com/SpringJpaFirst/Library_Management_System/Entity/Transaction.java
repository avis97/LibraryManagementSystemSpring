package com.SpringJpaFirst.Library_Management_System.Entity;


import com.SpringJpaFirst.Library_Management_System.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionNUmber;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    @CreationTimestamp
    private Date transactionDate;

    private boolean transactionIssued;
    private String Massage;

    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard card;
}
