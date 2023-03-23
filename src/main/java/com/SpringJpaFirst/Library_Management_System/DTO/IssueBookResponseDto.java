package com.SpringJpaFirst.Library_Management_System.DTO;


import com.SpringJpaFirst.Library_Management_System.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class IssueBookResponseDto{
      private String TransactionId;
      private String bookName;
      private int bookPrice;
      private TransactionStatus tStatus;
}
