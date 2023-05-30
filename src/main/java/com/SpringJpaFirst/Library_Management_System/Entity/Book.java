package com.SpringJpaFirst.Library_Management_System.Entity;

import com.SpringJpaFirst.Library_Management_System.Enum.ClassFor;
import com.SpringJpaFirst.Library_Management_System.Enum.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String bookTitle;
    private int price;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    private ClassFor classFor;
    private boolean bookIsIssued;
    @ManyToOne
    @JoinColumn
    Author author;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactionList=new ArrayList<>();
    @ManyToOne
    @JoinColumn
    LibraryCard card;
}
