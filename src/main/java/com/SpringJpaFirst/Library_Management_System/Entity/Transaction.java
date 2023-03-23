package com.SpringJpaFirst.Library_Management_System.Entity;


import com.SpringJpaFirst.Library_Management_System.Enum.Transactionstatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

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
    private String tranNUmber;
    @Enumerated(EnumType.STRING)
    private Transactionstatus tStatus;
    @CreationTimestamp
    private Date transactionDate;

    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LibraryCard card;
}
