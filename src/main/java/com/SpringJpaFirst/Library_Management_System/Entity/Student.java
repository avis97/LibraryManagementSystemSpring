package com.SpringJpaFirst.Library_Management_System.Entity;

import com.SpringJpaFirst.Library_Management_System.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String email;
    @OneToOne(mappedBy ="student",cascade = CascadeType.ALL)
    LibraryCard card;
}
