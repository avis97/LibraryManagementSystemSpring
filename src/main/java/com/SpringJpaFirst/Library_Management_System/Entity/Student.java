package com.SpringJpaFirst.Library_Management_System.Entity;

import com.SpringJpaFirst.Library_Management_System.Enum.Department;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private int studentAge;
    @Enumerated(EnumType.STRING)
    private Department department;
    private String studentEmail;

    @Column(name = "Image_File")
    private String imageName;
    @OneToOne(mappedBy ="student",cascade = CascadeType.ALL)
    LibraryCard card;
}
