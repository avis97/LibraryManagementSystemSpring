package com.SpringJpaFirst.Library_Management_System.Entity;
import com.SpringJpaFirst.Library_Management_System.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;
    private String validDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private Date creatationDate;
    @UpdateTimestamp
    private Date updateDate;
    @OneToOne
    @JoinColumn
    Student student;
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactionList=new ArrayList<>();
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> bookIssued=new ArrayList<>();
}
