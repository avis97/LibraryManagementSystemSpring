package com.SpringJpaFirst.Library_Management_System.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IssueBookRequestDto{
      private int cardId;
      private int bookId;
}
