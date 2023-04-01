package com.SpringJpaFirst.Library_Management_System.Entity;

import lombok.*;
import java.util.*;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String authorName;
    private int authorAge;
    private String authorPhoneNo;
    private String authorEmail;
    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    List<Book> book=new ArrayList<>();
}
